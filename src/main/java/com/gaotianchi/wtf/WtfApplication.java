package com.gaotianchi.wtf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WtfApplication {

    public static void main(String[] args) {
        SpringApplication.run(WtfApplication.class, args);
    }

}
