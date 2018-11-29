package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {

    @SerializedName("id")
    private int employeeId;

    @SerializedName("code")
    private String employeeCode;

    @SerializedName("name")
    private String employeeName;

    @SerializedName("password")
    private String employeePassword;

    @SerializedName("salary")
    private String employeeSalary;

    @SerializedName("roleid")
    private int employeeRoleId;

    @SerializedName("departmentid")
    private int employeeDepartmentId;

    @SerializedName("remainingleave")
    private int employeeRemainingLeave;

    @SerializedName("startworkingdate")
    private String employeeStartWorkingDate;

    @SerializedName("createddate")
    private String employeeCreatedDate;

    @SerializedName("updateddate")
    private String employeeUpdatedDate;

    public Employee(int employeeId, String employeeCode, String employeeName, String employeePassword, String employeeSalary, int employeeRoleId, int employeeDepartmentId, int profileRemainingLeave, String profileStartWorkingDate, String profileCreatedDate, String profileUpdatedDate) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeePassword = employeePassword;
        this.employeeSalary = employeeSalary;
        this.employeeRoleId = employeeRoleId;
        this.employeeDepartmentId = employeeDepartmentId;
        this.employeeRemainingLeave = profileRemainingLeave;
        this.employeeStartWorkingDate = profileStartWorkingDate;
        this.employeeCreatedDate = profileCreatedDate;
        this.employeeUpdatedDate = profileUpdatedDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeRoleId() {
        return employeeRoleId;
    }

    public void setEmployeeRoleId(int employeeRoleId) {
        this.employeeRoleId = employeeRoleId;
    }

    public int getEmployeeDepartmentId() {
        return employeeDepartmentId;
    }

    public void setEmployeeDepartmentId(int employeeDepartmentId) {
        this.employeeDepartmentId = employeeDepartmentId;
    }

    public int getEmployeeRemainingLeave() {
        return employeeRemainingLeave;
    }

    public void setEmployeeRemainingLeave(int employeeRemainingLeave) {
        this.employeeRemainingLeave = employeeRemainingLeave;
    }

    public String getEmployeeStartWorkingDate() {
        return employeeStartWorkingDate;
    }

    public void setEmployeeStartWorkingDate(String employeeStartWorkingDate) {
        this.employeeStartWorkingDate = employeeStartWorkingDate;
    }

    public String getEmployeeCreatedDate() {
        return employeeCreatedDate;
    }

    public void setEmployeeCreatedDate(String employeeCreatedDate) {
        this.employeeCreatedDate = employeeCreatedDate;
    }

    public String getEmployeeUpdatedDate() {
        return employeeUpdatedDate;
    }

    public void setEmployeeUpdatedDate(String employeeUpdatedDate) {
        this.employeeUpdatedDate = employeeUpdatedDate;
    }
}
