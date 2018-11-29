package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Profile {

    @SerializedName("id")
    private int profileId;

    @SerializedName("code")
    private String profileCode;

    @SerializedName("name")
    private String profileName;

    @SerializedName("password")
    private String profilePassword;

    @SerializedName("salary")
    private String profileSalary;

    @SerializedName("roleid")
    private int profileRoleId;

    @SerializedName("remainingleave")
    private int profileRemainingLeave;

    @SerializedName("startworkingdate")
    private int profileStartWorkingDate;

    @SerializedName("createddate")
    private Date profileCreatedDate;

    @SerializedName("updateddate")
    private Date profileUpdatedDate;

    @SerializedName("department")
    private String profileDepartment;

    @SerializedName("role")
    private String profileRole;

    public Profile(int profileId, String profileCode, String profileName, String profilePassword, String profileSalary, int profileRoleId, int profileRemainingLeave, int profileStartWorkingDate, Date profileCreatedDate, Date profileUpdatedDate, String profileDepartment, String profileRole) {
        this.profileId = profileId;
        this.profileCode = profileCode;
        this.profileName = profileName;
        this.profilePassword = profilePassword;
        this.profileSalary = profileSalary;
        this.profileRoleId = profileRoleId;
        this.profileRemainingLeave = profileRemainingLeave;
        this.profileStartWorkingDate = profileStartWorkingDate;
        this.profileCreatedDate = profileCreatedDate;
        this.profileUpdatedDate = profileUpdatedDate;
        this.profileDepartment = profileDepartment;
        this.profileRole = profileRole;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileCode() {
        return profileCode;
    }

    public void setProfileCode(String profileCode) {
        this.profileCode = profileCode;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getProfilePassword() {
        return profilePassword;
    }

    public void setProfilePassword(String profilePassword) {
        this.profilePassword = profilePassword;
    }

    public String getProfileSalary() {
        return profileSalary;
    }

    public void setProfileSalary(String profileSalary) {
        this.profileSalary = profileSalary;
    }

    public int getProfileRoleId() {
        return profileRoleId;
    }

    public void setProfileRoleId(int profileRoleId) {
        this.profileRoleId = profileRoleId;
    }

    public int getProfileRemainingLeave() {
        return profileRemainingLeave;
    }

    public void setProfileRemainingLeave(int profileRemainingLeave) {
        this.profileRemainingLeave = profileRemainingLeave;
    }

    public int getProfileStartWorkingDate() {
        return profileStartWorkingDate;
    }

    public void setProfileStartWorkingDate(int profileStartWorkingDate) {
        this.profileStartWorkingDate = profileStartWorkingDate;
    }

    public Date getProfileCreatedDate() {
        return profileCreatedDate;
    }

    public void setProfileCreatedDate(Date profileCreatedDate) {
        this.profileCreatedDate = profileCreatedDate;
    }

    public Date getProfileUpdatedDate() {
        return profileUpdatedDate;
    }

    public void setProfileUpdatedDate(Date profileUpdatedDate) {
        this.profileUpdatedDate = profileUpdatedDate;
    }

    public String getProfileDepartment() {
        return profileDepartment;
    }

    public void setProfileDepartment(String profileDepartment) {
        this.profileDepartment = profileDepartment;
    }

    public String getProfileRole() {
        return profileRole;
    }

    public void setProfileRole(String profileRole) {
        this.profileRole = profileRole;
    }
}
