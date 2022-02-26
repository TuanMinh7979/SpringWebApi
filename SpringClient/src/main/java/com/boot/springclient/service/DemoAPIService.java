package com.boot.springclient.service;


import com.boot.springclient.models.Product;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface DemoAPIService {
    @GET("/")
    Call<ResponseBody> demo1();

    @GET("/api/demo/demo3/{fullname}")
    Call<ResponseBody> demo3(@Path("fullname") String fullname);

    @GET("/api/product/find")
    Call<Product> findProduct();


    @GET("/api/product/findAll")
    Call<List<Product>> findAllProduct();

    @POST("/api/product/create")
    Call<Product> createProduct(@Body Product product);

    @PUT("/api/product/update/{id}")
    Call<Product> updateProduct(@Path("id") String id , @Body Product product);

    @DELETE("/api/product/delete/{id}")
    Call<Void> deleteProduct(@Path("id") String id );
}
