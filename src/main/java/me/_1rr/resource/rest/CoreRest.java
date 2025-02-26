package me._1rr.resource.rest;

import me._1rr.resource.service.CoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * 应用功能核心，实现短链接跳转
 *
 * @author gaotianchi
 * @since 2025/2/13 10:02
 **/
@Slf4j
@RestController
@RequestMapping("")
public class CoreRest {

    private final CoreService coreService;

    public CoreRest(CoreService coreService) {
        this.coreService = coreService;
    }

    @GetMapping("{code}")
    public ResponseEntity<Void> redirect(
            @PathVariable String code,
            @RequestParam(value = "password", required = false) String password
    ) throws URISyntaxException {

        String originalUrl = coreService.getOriginalUrl(code, password);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(new URI(originalUrl))
                .build();
    }
}
