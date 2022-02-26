package com.boot.springclient.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.annotations.SerializedName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private int price;
    @SerializedName("active")
    private  boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private int quanlity;
//    @DateTimeFormat (pattern="yyyy-MM-dd")
    @SerializedName("created")
    private Date created;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuanlity() {
        return quanlity;
    }

    public void setQuanlity(int quanlity) {
        this.quanlity = quanlity;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Product(String id, String name, int price, int quanlity, boolean active, Date created) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quanlity = quanlity;
        this.created = created;
        this.active=active;
    }

    public Product() {
    }

    @Override
    public String toString() {
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        return "Product{" +
                "Id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quanlity=" + quanlity +
//                ", date=" + simpleDateFormat.format(created) +
                '}';
    }


}
