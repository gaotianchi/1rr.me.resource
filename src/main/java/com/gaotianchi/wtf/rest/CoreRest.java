package com.gaotianchi.wtf.rest;

import com.gaotianchi.wtf.service.LinkService;
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

    private final LinkService linkService;

    public CoreRest(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code, @RequestParam(value = "password", required = false) String password) throws URISyntaxException {
        // 1. 检验 code 格式是否符合规范
        //      - 长度范围为 3 - 6
        //      - 只能出现特定字符（大小写字母以及数字）
        //      - 其他要求
        if (!linkService.validateCode(code)) {
            throw new IllegalArgumentException("code 格式不符合规范");
        }

        // 2. 根据 code 查找相关实体
        //      - 原始链接
        //      - 有效期
        //      - 跳转密码
        //      - 拥有者信息
        //      - 其他信息

        String longUrl = "";

        return ResponseEntity.status(HttpStatus.FOUND).location(new URI(longUrl)).build();
    }
}
