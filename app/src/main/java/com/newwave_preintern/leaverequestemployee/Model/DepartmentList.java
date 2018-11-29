package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DepartmentList {

    @SerializedName("department")
    private List<Department> departmentList;

    public DepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
}
