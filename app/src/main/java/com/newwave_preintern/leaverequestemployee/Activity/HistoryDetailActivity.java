package com.newwave_preintern.leaverequestemployee.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.newwave_preintern.leaverequestemployee.Model.Employee;
import com.newwave_preintern.leaverequestemployee.Model.Request;
import com.newwave_preintern.leaverequestemployee.R;
import com.newwave_preintern.leaverequestemployee.ViewModel.EmployeeViewModel;
import com.newwave_preintern.leaverequestemployee.ViewModel.RoleViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_history_detail)
    Toolbar toolbar;

    @BindView(R.id.tvHistoryDecision) TextView historyDecision;
    @BindView(R.id.imgHistoryDecision) ImageView imgDecision;

    @BindView(R.id.tvHistoryName) TextView historyName;
    @BindView(R.id.tvHistoryRole) TextView historyRole;
    @BindView(R.id.tvHistoryStartDate) TextView historyStartDate;
    @BindView(R.id.tvHistoryEndDate) TextView historyEndDate;
    @BindView(R.id.tvHistoryLeavesDay) TextView historyNoOfDays;
    @BindView(R.id.tvHistoryReason) TextView historyReason;
    @BindView(R.id.tvHistoryDuty) TextView historyHelpEmployee;
    @BindView(R.id.tvHistoryTypeOfDuty) TextView historyTypeOfDuty;
    @BindView(R.id.tvHistorySubmitDuty) TextView historySubmitDuty;

    private Request request;
    private EmployeeViewModel employeeViewModel;
    private RoleViewModel roleViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

        ButterKnife.bind(this);

        //SetToolbar
        toolbar.setTitle("Leave Form");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorTabIcon), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        setDecision();

        setData();


    }

    public void setData()
    {
        ButterKnife.bind(this);
        request = (Request) getIntent().getSerializableExtra("request");

        int employeeId = request.getRequestEmployeeId();

        //SetName
        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        employeeViewModel.getEmployeeName(this, employeeId)
                .observe(this, employeeList1 ->
                {
                    historyName.setText(employeeList1.getEmployeeList().get(0).getEmployeeName());
                });
        //SetHelperName
        employeeViewModel.getHelpEmployeeName(this, request.getRequestHelpingEmpId())
                .observe(this, employeeList ->
                {
                    historyHelpEmployee.setText(employeeList.getEmployeeList().get(0).getEmployeeName());
                });

        //SetRole
        roleViewModel = ViewModelProviders.of(this).get(RoleViewModel.class);
        employeeViewModel.getEmployeeRoleId(this, employeeId)
                .observe(this, employeeList ->
                {
                    roleViewModel.getRole(this, employeeList.getEmployeeList().get(0).getEmployeeRoleId())
                            .observe(this, roleList -> {
                                historyRole.setText(roleList.getRoleList().get(0).getRoleTitle());
                            });
                });

        historyStartDate.setText(request.getRequestStartDate().substring(0, 10));
        historyEndDate.setText(request.getRequestEndDate().substring(0, 10));
        historyNoOfDays.setText(request.getRequestTotalDays()+"");
        historyReason.setText(request.getRequestReason());
        historyTypeOfDuty.setText(request.getRequestAssignTask());

        int explainWell = request.getRequestExplained();
        String explained="";
        if(explainWell==1) explained = "Yes";
        else explained = "No";
        historySubmitDuty.setText(explained);
    }

    public void setDecision()
    {
        ButterKnife.bind(this);
        String decision = getIntent().getStringExtra("decision");
        if(decision.equals("accept"))
        {
            historyDecision.setTextColor(getResources().getColor(R.color.colorAccent));
            historyDecision.setText("Your Request was Accepted!");
            imgDecision.setImageResource(R.drawable.ic_leave_accept);

        }
        else if(decision.equals("pending"))
        {
            historyDecision.setTextColor(getResources().getColor(R.color.colorPending));
            historyDecision.setText("Your Request is Pending!");
            imgDecision.setImageResource(R.drawable.ic_request_pending);

        }
        else
        {
            historyDecision.setTextColor(getResources().getColor(R.color.colorTextInvalid));
            historyDecision.setText("Your Request was Denied!");
            imgDecision.setImageResource(R.drawable.ic_leave_denied);
        }
    }

}
