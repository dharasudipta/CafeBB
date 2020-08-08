package com.haveitfast.cafe.bbuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.haveitfast.cafe.bbuserservice"})
public class BbUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbUserServiceApplication.class, args);
    } 

}

