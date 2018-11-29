package com.newwave_preintern.leaverequestemployee.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.newwave_preintern.leaverequestemployee.Model.Request;
import com.newwave_preintern.leaverequestemployee.Network.RetrofitBuild;
import com.newwave_preintern.leaverequestemployee.R;
import com.newwave_preintern.leaverequestemployee.ViewModel.EmployeeViewModel;
import com.newwave_preintern.leaverequestemployee.ViewModel.RequestViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LeaveFormActivity extends AppCompatActivity {

    @BindView(R.id.toolbarLeaveForm)
    Toolbar toolbar;
    @BindView(R.id.spinnerDuty)
    Spinner spinner;

    @BindView(R.id.imgFromDate)
    ImageView imgFromDate;
    @BindView(R.id.imgToDate)
    ImageView imgToDate;

    @BindView(R.id.tvFromDate)
    TextView tvFromDate;
    @BindView(R.id.tvToDate)
    TextView tvToDate;

    @BindView(R.id.edtNoOfDays)
    EditText noOfDays;
    @BindView(R.id.edtReason)
    EditText reason;
    @BindView(R.id.edtTypeOfDuty)
    EditText typeOfDuty;

    @BindView(R.id.radioGroupSubmitDuty)
    RadioGroup radioGroup;
    @BindView(R.id.radioSubmitDutyYes)
    RadioButton radioButtonYes;
    @BindView(R.id.radioSubmitDutyNo)
    RadioButton radioButtonNo;

    CalendarView calendarView;
    private Dialog dialog;
    private RetrofitBuild retrofitBuild;
    private String[] staff;
    private int explained;
    private boolean notNullTest;
    private String helpEmployeeID;

    private EmployeeViewModel employeeViewModel;
    private RequestViewModel requestViewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_form);

        ButterKnife.bind(this);

        //SetToolbar
        toolbar.setTitle("Leave Form");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.colorTabIcon), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        //Set Date
        imgFromDate.setOnClickListener(view -> showCalendarFromDate());
        tvFromDate.setOnClickListener(view -> showCalendarFromDate());

        imgToDate.setOnClickListener(view -> showCalendarToDate());
        tvToDate.setOnClickListener(view -> showCalendarToDate());

        //Set Spinner
        String employeeName = getIntent().getStringExtra("employeeName");
        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        employeeViewModel.getEmployee(this)
                .observe(this, employeeList ->
                {
                    try {
                        staff = new String[employeeList.getEmployeeList().size()-1];
                        for (int i = 0; i < staff.length; i++) {
                            if(!(employeeName.equals(employeeList.getEmployeeList().get(i).getEmployeeName())))
                                staff[i] = employeeList.getEmployeeList().get(i).getEmployeeName();
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, staff);
                        spinner.setAdapter(adapter);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void showCalendarFromDate() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup_calendar_view);

        calendarView = dialog.findViewById(R.id.leaveFormCalendarView);
        calendarView.setOnDateChangeListener((calendarView1, year, month, dayOfMonth) -> {

            tvFromDate.setText(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(dayOfMonth));
            dialog.dismiss();

        });
        dialog.show();
    }

    public void showCalendarToDate() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup_calendar_view);

        calendarView = dialog.findViewById(R.id.leaveFormCalendarView);
        calendarView.setOnDateChangeListener((calendarView1, year, month, dayOfMonth) -> {

            tvToDate.setText(String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(dayOfMonth));
            dialog.dismiss();

        });
        dialog.show();
    }

    @OnClick(R.id.btSubitLeaveNo)
    public void btLeaveNo() {

        clearData();
    }

    public void clearData()
    {
        tvFromDate.setText("စတင္ခြင့္ယူမည့္ရက္");
        tvToDate.setText("ေနာက္ဆံုးခြင့္ယူမည့္ရက္");
        noOfDays.setText("");
        reason.setText("");
        typeOfDuty.setText("");
        radioGroup.clearCheck();
    }

    @OnClick(R.id.btSubitLeaveYes)
    public void btLeaveYes() {
        ButterKnife.bind(this);

        boolean leaveDayTest = true;
        boolean radioTest = true;
        String explainedStr = null;
        int remainDays = getIntent().getIntExtra("remainLeave", 1111);
        try
        {
            explainedStr = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
        }
        catch (Exception e)
        {
            radioTest = false;
        }

        if ((!tvFromDate.getText().equals("စတင္ခြင့္ယူမည့္ရက္")) && (!tvToDate.getText().equals("ေနာက္ဆံုးခြင့္ယူမည့္ရက္")) && (!noOfDays.equals(""))
                && (!reason.equals("")) && (!typeOfDuty.equals("")) && radioTest==true)
        {
            //TestNoOfLeaveDays
            int leaveDays = Integer.parseInt(noOfDays.getText().toString());
            int leaveDayTestCalculate = remainDays - leaveDays;
            if(leaveDayTestCalculate<0) leaveDayTest = false;

            //Get Radio value
            if (explainedStr.equals("အင္း")) explained = 1;
            else if (explainedStr.equals("ဟင့္အင္း")) explained = 0;
            notNullTest = true;
        } else notNullTest = false;

        if (notNullTest == true) {
            if(leaveDayTest == true)
            {
                    //getHelpEmployeeID
                    employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
                    employeeViewModel.getEmployee(this)
                            .observe(this, employeeList ->
                            {
                                for (int i = 0; i < employeeList.getEmployeeList().size(); i++) {
                                    if (employeeList.getEmployeeList().get(i).getEmployeeName().equals(spinner.getSelectedItem().toString())) {
                                        helpEmployeeID = employeeList.getEmployeeList().get(i).getEmployeeId() + "";
                                    }
                                }
                            });

                    //insertNewRequest
                   int employeeId = this.getIntent().getIntExtra("employeeId", 1111);
                    int days = Integer.parseInt(noOfDays.getText().toString());
                    int helpId = Integer.parseInt(helpEmployeeID);
                    String fromDate = tvFromDate.getText().toString();
                    String toDate = tvToDate.getText().toString();
                    String reasonStr = reason.getText().toString();
                    String assignTask = typeOfDuty.getText().toString();

                    requestViewModel = ViewModelProviders.of(this).get(RequestViewModel.class);
                    requestViewModel.insertNewRequest(new Request(employeeId, days, fromDate, toDate, reasonStr
                            , "pending", helpId, explained,assignTask, "", ""),this);
                    clearData();
            }
            else
            {
                new AlertDialog.Builder(this)
                        .setTitle("Your remaining Leave Days is " + remainDays)
                        .setMessage("Please retype your leave days!")
                        .setPositiveButton("OK", (dialog, which) -> {
                            dialog.dismiss();
                        }).setNegativeButton("", null).show();
            }

        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Please Fill All Of The Fileds!")
                    .setPositiveButton("OK", (dialog, which) -> {
                        dialog.dismiss();
                    }).setNegativeButton("", null).show();
        }

    }

}
