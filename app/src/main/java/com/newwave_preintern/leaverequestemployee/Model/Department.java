package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

public class Department {

    @SerializedName("id")
    private int departmentId;

    @SerializedName("subtitle")
    private String departmentTitle;

    @SerializedName("description")
    private String departmentDescription;

    @SerializedName("createddate")
    private String departmentCreatedDate;

    @SerializedName("updateddate")
    private String departmentUpdatedDate;

    public Department(int departmentId, String departmentTitle, String departmentDescription, String departmentCreatedDate, String departmentUpdatedDate) {
        this.departmentId = departmentId;
        this.departmentTitle = departmentTitle;
        this.departmentDescription = departmentDescription;
        this.departmentCreatedDate = departmentCreatedDate;
        this.departmentUpdatedDate = departmentUpdatedDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public String getDepartmentCreatedDate() {
        return departmentCreatedDate;
    }

    public void setDepartmentCreatedDate(String departmentCreatedDate) {
        this.departmentCreatedDate = departmentCreatedDate;
    }

    public String getDepartmentUpdatedDate() {
        return departmentUpdatedDate;
    }

    public void setDepartmentUpdatedDate(String departmentUpdatedDate) {
        this.departmentUpdatedDate = departmentUpdatedDate;
    }
}
