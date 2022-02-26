package com.boot.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class initController {
    @GetMapping("")
    public String index() {
        return "WELCOME TO MY API";
    }
}
