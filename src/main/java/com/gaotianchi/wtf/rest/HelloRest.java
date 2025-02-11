package com.gaotianchi.wtf.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaotianchi
 * @since 2025/2/11 20:03
 **/
@RestController
@RequestMapping("hello")
public class HelloRest {

    @GetMapping("")
    public String hello(
            @RequestParam(value = "name", defaultValue = "World") String name
    ) {
        return "Hello " + name;
    }
}
