package com.newwave_preintern.leaverequestemployee.Network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuild {

    private static final String BASE_URI = "http://128.199.250.101:5000/";
    private ApiService apiService;
    private Retrofit retrofit;

    public RetrofitBuild() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }

    public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
}
