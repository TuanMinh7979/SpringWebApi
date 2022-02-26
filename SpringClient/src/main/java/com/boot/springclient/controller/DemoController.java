package com.boot.springclient.controller;

import com.boot.springclient.models.Product;
import com.boot.springclient.service.ApiClient;
import com.boot.springclient.service.DemoAPIService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

@Controller
@RequestMapping("/")
public class DemoController {
    @GetMapping("")
    public String demo1(ModelMap map) {
        try {
            DemoAPIService demoAPIService = ApiClient.getClient().create(DemoAPIService.class);
            Response<ResponseBody> response = demoAPIService.demo1().execute();
//            System.out.println("" + response.isSuccessful());
            String value = response.body().string();
//            System.out.println("VALUE LA: " + value);
            map.put("value", value);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "index";
    }

    //link de vao getdemo3api
    @PostMapping("/getdemo3api")
    public String demo3(ModelMap map, @RequestParam("fullnameclient") String fullnameclient) {
        DemoAPIService demoAPIService = ApiClient.getClient().create(DemoAPIService.class);
        try {
            //nhu vay la khi goi tu client thi tham so  query string tuong minh tren url se dc nhan
            //boi client va api se chi code theo dang @PathVariable cho client goi
            System.out.println("fullname client" + fullnameclient);
            Response<ResponseBody> response = demoAPIService.demo3(fullnameclient).execute();
            if (response.body() != null) {
                String rs = response.body().string();
                map.put("result", rs);
            } else {
                map.put("result", "null r con dau");
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", null);
        }


        return "demo3";
    }

    @GetMapping("/findProduct")
    public String findProduct(ModelMap map) {
        try {
            DemoAPIService demoAPIService = ApiClient.getClient().create(DemoAPIService.class);
            Product product = demoAPIService.findProduct().execute().body();

            map.put("productfinded", product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "product-edit";
    }
    @GetMapping("/findAllProduct")
    public String findAllProduct(ModelMap map) {
        try {
            DemoAPIService demoAPIService = ApiClient.getClient().create(DemoAPIService.class);
            List<Product> products = demoAPIService.findAllProduct().execute().body();

            map.put("products", products);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/create-product")
    public String showProductForm(ModelMap map) {
        Product product = new Product();
        map.put("product", product);
        return "product-form";
    }

    @PostMapping("/create-product")
    public String handleProductAddForm(ModelMap map, @ModelAttribute("product") Product product) {

        DemoAPIService demoAPIService = ApiClient.getClient().create(DemoAPIService.class);
        try {

            //Server tra ve product thi minh lay ve product
            Product productcreated = demoAPIService.createProduct(product).execute().body();
            map.put("productcreated", productcreated);


        } catch (Exception e) {
            e.printStackTrace();
            map.put("productcreated", null);
        }
        return "index";
    }

    @PostMapping("/update-product")
    public String handleProductUpdateForm(ModelMap map, @ModelAttribute("productfinded") Product product) {
        try {
            //ta cung phai goi api
            DemoAPIService demoAPIService = ApiClient.getClient().create(DemoAPIService.class);
            Product productupdated = demoAPIService.updateProduct(product.getId(), product).execute().body();

            map.put("productupdated", product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String handleProductDelete(ModelMap map, @PathVariable("id") String id) {
        try {
            //ta cung phai goi api
            DemoAPIService demoAPIService = ApiClient.getClient().create(DemoAPIService.class);
            boolean  isdeleted =demoAPIService.deleteProduct(id).execute().isSuccessful();

            map.put("isdeleted", isdeleted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "index";
    }

}
