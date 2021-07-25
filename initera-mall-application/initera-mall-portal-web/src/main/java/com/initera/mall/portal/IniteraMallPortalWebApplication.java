package com.initera.mall.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author youngmate
 */
@SpringBootApplication(scanBasePackages = {"com.initera"})
public class IniteraMallPortalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(IniteraMallPortalWebApplication.class, args);
    }


}
