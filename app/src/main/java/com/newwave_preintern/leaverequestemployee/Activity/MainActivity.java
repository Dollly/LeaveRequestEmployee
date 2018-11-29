package com.newwave_preintern.leaverequestemployee.Activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.newwave_preintern.leaverequestemployee.Model.Employee;
import com.newwave_preintern.leaverequestemployee.Network.ApiService;
import com.newwave_preintern.leaverequestemployee.Network.RetrofitBuild;
import com.newwave_preintern.leaverequestemployee.R;
import com.newwave_preintern.leaverequestemployee.ViewModel.EmployeeViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Emitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvInvalid) TextView tvLoginInvalid;
    @BindView(R.id.edtCode) EditText code;
    @BindView(R.id.edtPassword) EditText password;

    private RetrofitBuild retrofitBuild;
    private Employee employee;
    private EmployeeViewModel employeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }
    @OnClick(R.id.btLogin)
    public void btLogin()
    {
        ButterKnife.bind(this);

        String nameStr = String.valueOf(code.getText());
        String passwordStr = String.valueOf(password.getText());

        if(nameStr.equals("") || passwordStr.equals(""))
        {
            tvLoginInvalid.setText("Code or Password Incorrect!");
        }
        else
        {

            /*employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
            employeeViewModel.logIn(this, nameStr, passwordStr)
                    .observe(this, employeeListLogIn ->
                    {
                        try{
                            String name = employeeListLogIn.getEmployeeList().get(0).getEmployeeName();
                            if(!name.equals(""))
                            {
                                employee = new Employee(employeeListLogIn.getEmployeeList().get(0).getEmployeeId()
                                        , employeeListLogIn.getEmployeeList().get(0).getEmployeeCode()
                                        , employeeListLogIn.getEmployeeList().get(0).getEmployeeName()
                                        , employeeListLogIn.getEmployeeList().get(0).getEmployeePassword()
                                        ,employeeListLogIn.getEmployeeList().get(0).getEmployeeSalary()
                                        ,employeeListLogIn.getEmployeeList().get(0).getEmployeeRoleId()
                                        ,employeeListLogIn.getEmployeeList().get(0).getEmployeeDepartmentId()
                                        ,employeeListLogIn.getEmployeeList().get(0).getEmployeeRemainingLeave()
                                        ,employeeListLogIn.getEmployeeList().get(0).getEmployeeStartWorkingDate()
                                        ,employeeListLogIn.getEmployeeList().get(0).getEmployeeCreatedDate()
                                        ,employeeListLogIn.getEmployeeList().get(0).getEmployeeUpdatedDate());
                                Intent intent = new Intent(this, Tab.class);
                                intent.putExtra("employee", employee);
                                startActivity(intent);
                            }

                        }
                        catch (IndexOutOfBoundsException e)
                        {
                            tvLoginInvalid.setText("Code or Password Incorrect!");
                        }
                    });*/

            retrofitBuild = new RetrofitBuild();
            retrofitBuild.getApiService().login(nameStr, passwordStr)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(employeeList ->
                    {
                        try{
                            String name = employeeList.getEmployeeList().get(0).getEmployeeName();
                            if(!name.equals(""))
                            {
                                employee = new Employee(employeeList.getEmployeeList().get(0).getEmployeeId()
                                        , employeeList.getEmployeeList().get(0).getEmployeeCode()
                                        , employeeList.getEmployeeList().get(0).getEmployeeName()
                                        , employeeList.getEmployeeList().get(0).getEmployeePassword()
                                        ,employeeList.getEmployeeList().get(0).getEmployeeSalary()
                                        ,employeeList.getEmployeeList().get(0).getEmployeeRoleId()
                                        ,employeeList.getEmployeeList().get(0).getEmployeeDepartmentId()
                                        ,employeeList.getEmployeeList().get(0).getEmployeeRemainingLeave()
                                        ,employeeList.getEmployeeList().get(0).getEmployeeStartWorkingDate()
                                        ,employeeList.getEmployeeList().get(0).getEmployeeCreatedDate()
                                        ,employeeList.getEmployeeList().get(0).getEmployeeUpdatedDate());
                                Intent intent = new Intent(this, Tab.class);
                                intent.putExtra("employee", employee);
                                startActivity(intent);
                            }

                        }
                        catch (IndexOutOfBoundsException e)
                        {
                            tvLoginInvalid.setText("Code or Password Incorrect!");
                        }
                    }, throwable -> Toast.makeText(getApplicationContext(), throwable.getLocalizedMessage()+"", Toast.LENGTH_LONG).show());

        }

    }
}
