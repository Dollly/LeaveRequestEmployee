package com.newwave_preintern.leaverequestemployee.Network;

import com.newwave_preintern.leaverequestemployee.Model.DepartmentList;
import com.newwave_preintern.leaverequestemployee.Model.EmployeeList;
import com.newwave_preintern.leaverequestemployee.Model.EmployeeListLogIn;
import com.newwave_preintern.leaverequestemployee.Model.RequestList;
import com.newwave_preintern.leaverequestemployee.Model.RoleList;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("authapi/loginemployee?")
    Single<EmployeeListLogIn> login(@Query("name") String name, @Query("password") String password);

    @GET("api/employee")
    Single<EmployeeList> getEmployee();

    @GET("api/employee")
    Single<EmployeeList> getEmployeeName(@Query("w") String id);

    @GET("api/role?")
    Single<RoleList> getRole(@Query("w=id") int id);

    @GET("api/department/{id}")
    Single<DepartmentList> getDepartment(@Path("id") int id);

    @POST("api/request")
    @FormUrlEncoded
    Single<Integer> insertRequest(@Field("employeeid")int requestEmployeeId
                                        , @Field("totaldays")int requestTotalDays
                                        , @Field("startdate")String requestStartDate
                                        , @Field("enddate")String requestEndDate
                                        , @Field("reason")String requestReason
                                        , @Field("determine") String requestDetermine
                                        , @Field("assigntask") String requestAssignTask
                                        , @Field("helpingempid")int requestHelpingEmpId
                                        , @Field("explained")int requestExplained
                                        , @Field("createddate")String requestCreatedDate
                                        , @Field("updateddate")String requestUpdateDate);

    @GET("api/request")
    Single<RequestList> getRequestHistory(@Query("w") String id);
}
