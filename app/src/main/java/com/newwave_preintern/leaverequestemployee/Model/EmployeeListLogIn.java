package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeListLogIn{

    @SerializedName("d")
    private List<Employee> employeeList;

    public EmployeeListLogIn(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
