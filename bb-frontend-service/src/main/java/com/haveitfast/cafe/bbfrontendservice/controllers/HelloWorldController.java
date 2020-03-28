package com.haveitfast.cafe.bbfrontendservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String home() {
        return "Hello, SpringBootApplication is working ";
    }
}
