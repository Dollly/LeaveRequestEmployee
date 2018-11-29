package com.newwave_preintern.leaverequestemployee.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

import com.newwave_preintern.leaverequestemployee.Model.RoleList;
import com.newwave_preintern.leaverequestemployee.Network.RetrofitBuild;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RoleViewModel extends ViewModel {

    private MutableLiveData<RoleList> roleList;
    private RetrofitBuild retrofitBuild;

    public MutableLiveData<RoleList> getRole(Context context, int id)
    {
        if(roleList == null)
        {
            roleList = new MutableLiveData<>();
            retrofitBuild = new RetrofitBuild();
            retrofitBuild.getApiService().getRole(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(roleList1 ->
                    {
                        roleList.setValue(roleList1);
                    }, throwable -> {Toast.makeText(context, throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    });
        }
        return roleList;
    }


}
