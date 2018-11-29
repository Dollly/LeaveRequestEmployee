package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoleList {

    @SerializedName("role")
    private List<Role> roleList;

    public RoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
