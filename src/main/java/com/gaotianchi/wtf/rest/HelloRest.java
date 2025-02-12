package com.gaotianchi.wtf.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author gaotianchi
 * @since 2025/2/11 20:03
 **/
@Slf4j
@RestController
@RequestMapping("hello")
public class HelloRest {


    @Operation(
            summary = "对某人说 'hello'",
            description = "这是一个简单的 REST 接口，用于向某人说 'hello'。"
    )
    @GetMapping("")
    public String hello(
            @Parameter(
                    description = "要对其说 'hello' 的人的名字",
                    example = "World"
            )
            @RequestParam(value = "name", defaultValue = "World")
            String name
    ) {
        log.info("hello {}", name);
        return "Hello " + name;
    }
}
