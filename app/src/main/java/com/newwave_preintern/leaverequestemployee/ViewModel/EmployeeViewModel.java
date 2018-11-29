package com.newwave_preintern.leaverequestemployee.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.widget.Toast;

import com.newwave_preintern.leaverequestemployee.Model.EmployeeList;
import com.newwave_preintern.leaverequestemployee.Model.EmployeeListLogIn;
import com.newwave_preintern.leaverequestemployee.Network.RetrofitBuild;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class EmployeeViewModel extends ViewModel {

    private MutableLiveData<EmployeeList> employeeList;
    private MutableLiveData<EmployeeList> helpEmployeeList;
    private MutableLiveData<EmployeeList> roleEmployeeList;
    private MutableLiveData<EmployeeListLogIn> employeeListLogIn;
    private RetrofitBuild retrofitBuild;

    public MutableLiveData<EmployeeList> getEmployee(Context context) {
        if (employeeList == null) {
            employeeList = new MutableLiveData<>();
            retrofitBuild = new RetrofitBuild();
            retrofitBuild.getApiService().getEmployee()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(employeeList1 ->
                    {
                        employeeList.setValue(employeeList1);
                    }, throwable -> {
                        Toast.makeText(context, throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    });
        }
        return employeeList;
    }

    public MutableLiveData<EmployeeList> getEmployeeName(Context context, int id)
    {
        if (employeeList == null) {
            employeeList = new MutableLiveData<>();
            retrofitBuild = new RetrofitBuild();
            retrofitBuild.getApiService().getEmployeeName("id="+id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(employeeList1 ->
                    {
                        employeeList.setValue(employeeList1);
                    }, throwable -> {
                        Toast.makeText(context, throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    });
        }
        return employeeList;
    }

    public MutableLiveData<EmployeeList> getHelpEmployeeName(Context context, int id)
    {
        if (helpEmployeeList == null) {
            helpEmployeeList = new MutableLiveData<>();
            retrofitBuild = new RetrofitBuild();
            retrofitBuild.getApiService().getEmployeeName("id="+id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(employeeList1 ->
                    {
                        helpEmployeeList.setValue(employeeList1);
                    }, throwable -> {
                        Toast.makeText(context, throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    });
        }
        return helpEmployeeList;
    }

    public MutableLiveData<EmployeeList> getEmployeeRoleId(Context context, int id)
    {
        if (roleEmployeeList == null) {
            roleEmployeeList = new MutableLiveData<>();
            retrofitBuild = new RetrofitBuild();
            retrofitBuild.getApiService().getEmployeeName("id="+id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(employeeList1 ->
                    {
                        roleEmployeeList.setValue(employeeList1);
                    }, throwable -> {
                        Toast.makeText(context, throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    });
        }
        return roleEmployeeList;
    }

    public MutableLiveData<EmployeeListLogIn> logIn(Context context, String name, String password) {
        if (employeeListLogIn == null) {
            employeeListLogIn = new MutableLiveData<>();
            retrofitBuild = new RetrofitBuild();
            retrofitBuild.getApiService().login(name, password)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(employeeListLogIn1 ->
                    {
                        employeeListLogIn.setValue(employeeListLogIn1);
                    }, throwable -> {
                        Toast.makeText(context, throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    });
        }
        return employeeListLogIn;
    }


}
