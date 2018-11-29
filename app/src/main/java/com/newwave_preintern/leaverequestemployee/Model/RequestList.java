package com.newwave_preintern.leaverequestemployee.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestList {

    @SerializedName("request")
    private List<Request> requestList;

    public RequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public RequestList()
    {}


    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }
}
