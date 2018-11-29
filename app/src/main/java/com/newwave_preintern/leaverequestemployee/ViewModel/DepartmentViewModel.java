package com.newwave_preintern.leaverequestemployee.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

import com.newwave_preintern.leaverequestemployee.Model.DepartmentList;
import com.newwave_preintern.leaverequestemployee.Network.RetrofitBuild;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DepartmentViewModel extends ViewModel {

    private MutableLiveData<DepartmentList> departmentList;
    private RetrofitBuild retrofitBuild;

    public MutableLiveData<DepartmentList> getDepartment(Context context, int id)
    {
        if(departmentList == null)
        {
            departmentList = new MutableLiveData<>();
            retrofitBuild = new RetrofitBuild();
            retrofitBuild.getApiService().getDepartment(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(departmentList1 ->
                    {
                        departmentList.setValue(departmentList1);
                    }, throwable -> {Toast.makeText(context, throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    });
        }
        return departmentList;
    }

}
