package com.boot.api.controller;

import com.boot.api.model.Product;
import com.boot.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.MimeType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "find", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> find() {
        try {
            return new ResponseEntity<Product>(productService.find(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "findAll")
    public ResponseEntity<List<Product>> findAll() {
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Kiem tra san pham co ton tai hay khong
    @GetMapping(value = "isExist/{id}")
    //voi gia tri boolean nen ep ve String
    public ResponseEntity<String> findAll(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<String>(String.valueOf(productService.exists(id)), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "total")
    public ResponseEntity<String> total() {
        try {
            return new ResponseEntity<String>(String.valueOf(productService.total()), HttpStatus.OK);
        } catch (Exception ex) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "search/{month}/{year}")
    //voi gia tri boolean nen ep ve String
    public ResponseEntity<List<Product>> Search(@PathVariable("month") int month, @PathVariable("year") int year) {
        try {
            return new ResponseEntity<>(productService.search(month, year), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "created", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    //voi gia tri boolean nen ep ve String
//    @RequestMapping(value="create", method=RequestMethod.POST);

    public ResponseEntity<Product> created(@RequestBody Product product) {

        try {
            return new ResponseEntity<>(productService.created(product), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "update/{id}", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    //voi gia tri boolean nen ep ve String
//    @RequestMapping(value="create", method=RequestMethod.POST);

    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody Product product) {

        try {
            return new ResponseEntity<>(productService.update(id, product), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping(value = "delete/{id}", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    //voi gia tri boolean nen ep ve String
//    @RequestMapping(value="create", method=RequestMethod.POST);

    public ResponseEntity<Void> delete(@PathVariable("id") String id) {

        try {
            return new ResponseEntity<Void>( HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




}
