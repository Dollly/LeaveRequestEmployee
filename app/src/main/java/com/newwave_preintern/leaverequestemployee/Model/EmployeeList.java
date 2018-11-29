package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeList {

    @SerializedName("employee")
    private List<Employee> employeeList;

    public EmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
