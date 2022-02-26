package com.boot.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product implements Serializable {
    private String Id;
    private String name;
    private int price;
    private  boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private int quanlity;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date created;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
        Id = id;
        this.name = name;
        this.price = price;
        this.quanlity = quanlity;
        this.created = created;
    }



    @Override
    public String toString() {
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        return "Product{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quanlity=" + quanlity +
//                ", date=" + simpleDateFormat.format(created) +
                '}';
    }


}
