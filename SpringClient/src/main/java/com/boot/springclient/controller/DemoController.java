package com.boot.springclient.controller;

import com.boot.springclient.service.ApiClient;
import com.boot.springclient.service.DemoAPIService;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

@Controller
@RequestMapping("/")
public class DemoController {
    @GetMapping("")
    public String demo1(ModelMap map) {
        try {
            DemoAPIService demoAPIService = ApiClient.getClient().create(DemoAPIService.class);
            Response<ResponseBody> response = demoAPIService.demo1().execute();
            System.out.println("" + response.isSuccessful());
            String value = response.body().string();
            System.out.println("VALUE LA: "+value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "index";
    }

}
