package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

public class Role {

    @SerializedName("id")
    private int roleId;

    @SerializedName("title")
    private String roleTitle;

    @SerializedName("description")
    private String roleDescription;

    @SerializedName("createddate")
    private String roleCreatedDate;

    @SerializedName("updateddate")
    private String roleUpdatedDate;

    public Role(int roleId, String roleTitle, String roleDescription, String roleCreatedDate, String roleUpdatedDate) {
        this.roleId = roleId;
        this.roleTitle = roleTitle;
        this.roleDescription = roleDescription;
        this.roleCreatedDate = roleCreatedDate;
        this.roleUpdatedDate = roleUpdatedDate;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleCreatedDate() {
        return roleCreatedDate;
    }

    public void setRoleCreatedDate(String roleCreatedDate) {
        this.roleCreatedDate = roleCreatedDate;
    }

    public String getRoleUpdatedDate() {
        return roleUpdatedDate;
    }

    public void setRoleUpdatedDate(String roleUpdatedDate) {
        this.roleUpdatedDate = roleUpdatedDate;
    }
}
