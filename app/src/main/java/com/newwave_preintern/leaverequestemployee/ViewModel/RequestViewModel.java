package com.newwave_preintern.leaverequestemployee.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

import com.newwave_preintern.leaverequestemployee.Model.Request;
import com.newwave_preintern.leaverequestemployee.Model.RequestList;
import com.newwave_preintern.leaverequestemployee.Network.RetrofitBuild;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RequestViewModel extends ViewModel {

    private RetrofitBuild retrofitBuild;
    private MutableLiveData<RequestList> requestList;

    public void insertNewRequest(Request request, Context context)
    {
        retrofitBuild = new RetrofitBuild();
        try {
            retrofitBuild.getApiService().insertRequest(request.getRequestEmployeeId(), request.getRequestTotalDays(), request.getRequestStartDate(),
                    request.getRequestEndDate(), request.getRequestReason(), request.getRequestDetermine(), request.getRequestAssignTask(),
                    request.getRequestHelpingEmpId(),request.getRequestExplained(), request.getRequestCreatedDate(), request.getRequestUpdateDate())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(integer ->
                    {
                        Toast.makeText(context, "Success!", Toast.LENGTH_LONG).show();
                    });
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public MutableLiveData<RequestList> getRequestHistory(Context context,int id)
    {
        if(requestList == null)
        {
            requestList = new MutableLiveData<>();
            retrofitBuild = new RetrofitBuild();
            retrofitBuild.getApiService().getRequestHistory("employeeid="+id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(requestList1 ->
                    {
                        requestList.setValue(requestList1);
                    },throwable -> {
                        Toast.makeText(context, throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    });
        }
        return requestList;
    }



}
