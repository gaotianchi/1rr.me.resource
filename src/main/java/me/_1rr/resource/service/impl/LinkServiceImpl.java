package me._1rr.resource.service.impl;

import me._1rr.resource.dao.LinkDao;
import me._1rr.resource.dto.LinkDto;
import me._1rr.resource.entity.Link;
import me._1rr.resource.service.CacheService;
import me._1rr.resource.service.CoreService;
import me._1rr.resource.service.LinkService;
import me._1rr.resource.vo.LinkCoreVo;
import me._1rr.resource.vo.LinkVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author gaotianchi
 * @since 2025/2/13 10:50
 **/
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    private final LinkDao linkDao;
    private final CoreService coreService;
    private final CacheService cacheService;

    public LinkServiceImpl(
            LinkDao linkDao,
            CoreService coreService,
            CacheService cacheService
    ) {
        this.linkDao = linkDao;
        this.coreService = coreService;
        this.cacheService = cacheService;
    }


    @Override
    public String createNewLink(
            String subject,
            LinkDto linkDto
    ) {
        String code = coreService.generateShortLinkCode(linkDto.getOriginalUrl());
        Link.LinkBuilder builder = Link.builder();
        builder
                .createdAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .username(subject)
                .originalUrl(linkDto.getOriginalUrl())
                .code(code)
                .password(linkDto.getPassword())
                .expiredAt(linkDto.getExpireAt())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy(subject)
                .updatedBy(subject);

        // 对于匿名用户，设置默认过期时间为7天
        if (subject == null) {
            builder.createdBy("anonymous");
            builder.updatedBy("anonymous");
            builder.username("anonymous");
            builder.expiredAt(LocalDateTime.now().plusDays(7));
        }

        Link link = builder.build();
        linkDao.insertLink(link);
        return code;
    }

    @Override
    public LinkCoreVo getLinkByCode(String code) {
        LinkCoreVo coreLinkByCode = cacheService.getCoreLinkByCode(code);
        coreLinkByCode.setPassword(null);
        return coreLinkByCode;
    }

    @Override
    public Page<LinkVo> getPageLinks(
            String subject,
            LinkDto linkDto
    ) {
        return null;
    }

    @Override
    public void updateLinkByCode(
            String shortLinkCode,
            LinkDto linkDto
    ) {

    }

    @Override
    public void deleteLinkByCode(String shortLinkCode) {

    }
}
