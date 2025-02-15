package com.gaotianchi.wtf.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 应用功能核心，实现短链接跳转
 * @author gaotianchi
 * @since 2025/2/13 10:02
 **/
@Slf4j
@RestController
@RequestMapping("")
public class CoreRest {

    @GetMapping("{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code, @RequestParam(value = "password", required = false) String password) throws URISyntaxException {

        String longUrl = "";

        return ResponseEntity.status(HttpStatus.FOUND).location(new URI(longUrl)).build();
    }
}
