package com.gaotianchi.wtf.rest;

import com.gaotianchi.wtf.dto.LinkDto;
import com.gaotianchi.wtf.service.LinkService;
import com.gaotianchi.wtf.service.impl.LinkServiceImpl;
import com.gaotianchi.wtf.vo.LinkVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * 管理短链接声明周期
 *
 * @author gaotianchi
 * @since 2025/2/15 13:52
 **/
@Slf4j
@RestController
@RequestMapping("api/links")
public class LinkRest {

    private final LinkService linkService;

    public LinkRest(LinkServiceImpl linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public ResponseEntity<Void> addNewLink(
            @AuthenticationPrincipal Jwt jwt,
            @RequestBody LinkDto linkDto
    ) {
        String short_link_code = linkService.createNewLink(jwt.getSubject(), linkDto);
        URI location = URI.create("/" + short_link_code);
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<LinkVo> getLinkByCode(
            @RequestParam(name = "code") String shortLinkCode
    ) {
        LinkVo linkVo = linkService.getLinkByCode(shortLinkCode);
        return ResponseEntity.ok(linkVo);
    }

    @GetMapping
    public ResponseEntity<Page<LinkVo>> getPageLinks(
            @AuthenticationPrincipal Jwt jwt,
            @ModelAttribute LinkDto linkDto
    ) {
        Page<LinkVo> links = linkService.getPageLinks(jwt.getSubject(), linkDto);
        return ResponseEntity.ok(links);
    }

    @PutMapping
    public ResponseEntity<Void> updateLinkByCode(
            @RequestParam(name = "code") String shortLinkCode,
            @RequestBody LinkDto linkDto
    ) {
        linkService.updateLinkByCode(shortLinkCode, linkDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLinkByCode(
            @RequestParam(name = "code") String shortLinkCode
    ) {
        linkService.deleteLinkByCode(shortLinkCode);
        return ResponseEntity.noContent().build();
    }
}
