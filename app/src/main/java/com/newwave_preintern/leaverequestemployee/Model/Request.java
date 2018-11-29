package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Request implements Serializable {

    @SerializedName("id")
    private int requestId;

    @SerializedName("employeeid")
    private int requestEmployeeId;

    @SerializedName("totaldays")
    private int requestTotalDays;

    @SerializedName("startdate")
    private String requestStartDate;

    @SerializedName("enddate")
    private String requestEndDate;

    @SerializedName("reason")
    private String requestReason;

    @SerializedName("determine")
    private String requestDetermine;

    @SerializedName("helpingempid")
    private int requestHelpingEmpId;

    @SerializedName("explained")
    private int requestExplained;

    @SerializedName("assigntask")
    private String requestAssignTask;

    @SerializedName("createddate")
    private String requestCreatedDate;

    @SerializedName("updateddate")
    private String requestUpdateDate;

    public Request(int requestEmployeeId, int requestTotalDays, String requestStartDate, String requestEndDate, String requestReason, String requestDetermine, int requestHelpingEmpId, int requestExplained, String requestAssignTask, String requestCreatedDate, String requestUpdateDate) {
        this.requestEmployeeId = requestEmployeeId;
        this.requestTotalDays = requestTotalDays;
        this.requestStartDate = requestStartDate;
        this.requestEndDate = requestEndDate;
        this.requestReason = requestReason;
        this.requestDetermine = requestDetermine;
        this.requestHelpingEmpId = requestHelpingEmpId;
        this.requestExplained = requestExplained;
        this.requestAssignTask = requestAssignTask;
        this.requestCreatedDate = requestCreatedDate;
        this.requestUpdateDate = requestUpdateDate;
    }

    public Request(int requestTotalDays, String requestStartDate, String requestEndDate, String requestReason, String requestDetermine, int requestHelpingEmpId, int requestExplained, String requestAssignTask, String requestCreatedDate) {
        this.requestTotalDays = requestTotalDays;
        this.requestStartDate = requestStartDate;
        this.requestEndDate = requestEndDate;
        this.requestReason = requestReason;
        this.requestDetermine = requestDetermine;
        this.requestHelpingEmpId = requestHelpingEmpId;
        this.requestExplained = requestExplained;
        this.requestAssignTask = requestAssignTask;
        this.requestCreatedDate = requestCreatedDate;
        this.requestUpdateDate = requestUpdateDate;
    }

    public Request() {
    }

    public String getRequestAssignTask() {
        return requestAssignTask;
    }

    public void setRequestAssignTask(String requestAssignTask) {
        this.requestAssignTask = requestAssignTask;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestEmployeeId() {
        return requestEmployeeId;
    }

    public void setRequestEmployeeId(int requestEmployeeId) {
        this.requestEmployeeId = requestEmployeeId;
    }

    public int getRequestTotalDays() {
        return requestTotalDays;
    }

    public void setRequestTotalDays(int requestTotalDays) {
        this.requestTotalDays = requestTotalDays;
    }

    public String getRequestStartDate() {
        return requestStartDate;
    }

    public void setRequestStartDate(String requestStartDate) {
        this.requestStartDate = requestStartDate;
    }

    public String getRequestEndDate() {
        return requestEndDate;
    }

    public void setRequestEndDate(String requestEndDate) {
        this.requestEndDate = requestEndDate;
    }

    public String getRequestReason() {
        return requestReason;
    }

    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason;
    }

    public String getRequestDetermine() {
        return requestDetermine;
    }

    public void setRequestDetermine(String requestDetermine) {
        this.requestDetermine = requestDetermine;
    }

    public int getRequestHelpingEmpId() {
        return requestHelpingEmpId;
    }

    public void setRequestHelpingEmpId(int requestHelpingEmpId) {
        this.requestHelpingEmpId = requestHelpingEmpId;
    }

    public int getRequestExplained() {
        return requestExplained;
    }

    public void setRequestExplained(int requestExplained) {
        this.requestExplained = requestExplained;
    }

    public String getRequestCreatedDate() {
        return requestCreatedDate;
    }

    public void setRequestCreatedDate(String requestCreatedDate) {
        this.requestCreatedDate = requestCreatedDate;
    }

    public String getRequestUpdateDate() {
        return requestUpdateDate;
    }

    public void setRequestUpdateDate(String requestUpdateDate) {
        this.requestUpdateDate = requestUpdateDate;
    }
}
