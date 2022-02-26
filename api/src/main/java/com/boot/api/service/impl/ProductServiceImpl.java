package com.boot.api.service.impl;

import com.boot.api.model.Product;
import com.boot.api.service.ProductService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product find() {
        return new Product("p01", "name1", 55, 22, false, new Date());
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            products.add(new Product("p01", "tivi1", 5, 22, false, sf.parse("15/10/2022")));
            products.add(new Product("p02", "phone1", 7, 25, false, sf.parse("16/11/2021")));
            products.add(new Product("p03", "tivi1", 10, 27, true, sf.parse("17/10/2021")));


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return products;
    }

    @Override
    public boolean exists(String id) {
        for (Product product : findAll()) {
            if (product.getId().equalsIgnoreCase(id))
                return true;
        }
        return false;
    }

    @Override
    public double total() {
        double sumprice = 0;
        for (Product p : findAll()) {
            sumprice += p.getPrice() * p.getQuanlity();
        }
        return sumprice;
    }

    //tim cac pham dc them vao db trong 1 thang cho trc
    @Override
    public List<Product> search(int month, int year) {
        List<Product> products= new ArrayList<>();
        for(Product product: findAll()){
            Calendar cal= Calendar.getInstance();
            cal.setTime(product.getCreated());
            int monthr=cal.get(Calendar.MONTH)+1;
            int yearr=cal.get(Calendar.YEAR);
            if(month==monthr && year==yearr){
                products.add(product);
            }

        }
        return products;
    }
//BUOI 2
    @Override
    public Product created(Product product) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Product - info- created");
        System.out.println(product.toString());
        return product;
    }

    @Override
    public Product update(String id, Product product) {
        System.out.println("UPDATE TASK");
        System.out.println("id: "+id);
        System.out.println("name:"+product.getName());
        System.out.println("price: "+product.getPrice());
        System.out.println("active:"+product.isActive());
        return product;
    }

    @Override
    public void delete(String id) {
        System.out.println("DELETE SUCCESS FULLY");
    }


}
