package com.boot.springclient.service;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DemoAPIService {
    @GET("/")
    Call<ResponseBody> demo1();
}
