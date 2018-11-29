package com.newwave_preintern.leaverequestemployee.Fragment;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.newwave_preintern.leaverequestemployee.Activity.HistoryDetailActivity;
import com.newwave_preintern.leaverequestemployee.Model.Employee;
import com.newwave_preintern.leaverequestemployee.Network.RetrofitBuild;
import com.newwave_preintern.leaverequestemployee.R;
import com.newwave_preintern.leaverequestemployee.ViewModel.DepartmentViewModel;
import com.newwave_preintern.leaverequestemployee.ViewModel.EmployeeViewModel;
import com.newwave_preintern.leaverequestemployee.ViewModel.RoleViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProfileFragment extends Fragment {

    @BindView(R.id.tvProfileName) TextView name;
    @BindView(R.id.tvProfileRole) TextView role;
    @BindView(R.id.tvProfileWorkStartDate) TextView workStartDate;
    @BindView(R.id.tvProfileDepartment) TextView department;
    @BindView(R.id.tvProfileSalary) TextView salary;
    @BindView(R.id.tvProfileRemainDays) TextView remainDays;

    private Employee employee;
    private RetrofitBuild retrofitBuild;
    private DepartmentViewModel departmentViewModel;
    private RoleViewModel roleViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ButterKnife.bind(this, view);

        retrofitBuild = new RetrofitBuild();

        employee = (Employee) getActivity().getIntent().getSerializableExtra("employee");
        name.setText(employee.getEmployeeName());

        roleViewModel = ViewModelProviders.of(getActivity()).get(RoleViewModel.class);
        roleViewModel.getRole(getContext(), employee.getEmployeeRoleId())
                .observe(getActivity(), roleList ->
                {
                    role.setText(roleList.getRoleList().get(0).getRoleTitle());
                });

        departmentViewModel = ViewModelProviders.of(getActivity()).get(DepartmentViewModel.class);
        departmentViewModel.getDepartment(getContext(), employee.getEmployeeDepartmentId())
                .observe(getActivity(),departmentList ->
                {
                    department.setText(departmentList.getDepartmentList().get(0).getDepartmentTitle());
                });

        workStartDate.setText(employee.getEmployeeStartWorkingDate().substring(0,10));
        salary.setText(employee.getEmployeeSalary());
        remainDays.setText(employee.getEmployeeRemainingLeave()+"");

        return view;

    }
}
