package com.boot.api.service;

import com.boot.api.model.Product;

import java.util.List;

public interface ProductService {
     Product find();
    List<Product> findAll();
    boolean exists(String id);
    double total();
    List<Product> search(int month, int year);
    Product created(Product product);
    Product update(String id, Product product);
    void delete(String id);

}
