package com.gaotianchi.wtf.rest;

import com.gaotianchi.wtf.service.ShortLinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author gaotianchi
 * @since 2025/2/13 10:02
 **/
@RestController
public class ShortLinkRest {

    private final ShortLinkService shortLinkService;

    public ShortLinkRest(ShortLinkService shortLinkService) {
        this.shortLinkService = shortLinkService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(
            @PathVariable String code,
            @RequestParam(value = "password", required = false) String password
    ) throws URISyntaxException {

        // 1. 检验 code 格式是否符合规范
        //      - 长度范围为 3 - 6
        //      - 只能出现特定字符（大小写字母以及数字）
        //      - 其他要求
        if (!shortLinkService.validateCode(code)) {
            throw new IllegalArgumentException("code 格式不符合规范");
        }

        // 2. 根据 code 查找相关实体
        //      - 原始链接
        //      - 有效期
        //      - 跳转密码
        //      - 拥有者信息
        //      - 其他信息

        String longUrl = "";

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(new URI(longUrl))
                .build();
    }
}
