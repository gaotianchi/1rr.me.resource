package com.gaotianchi.wtf.service.impl;

import com.gaotianchi.wtf.dao.LinkDao;
import com.gaotianchi.wtf.dto.LinkDto;
import com.gaotianchi.wtf.entity.Link;
import com.gaotianchi.wtf.service.CoreService;
import com.gaotianchi.wtf.service.LinkService;
import com.gaotianchi.wtf.vo.LinkVo;
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

    public LinkServiceImpl(
            LinkDao linkDao,
            CoreService coreService
    ) {
        this.linkDao = linkDao;
        this.coreService = coreService;
    }


    @Override
    public String createNewLink(
            String subject,
            LinkDto linkDto
    ) {
        String code = coreService.generateShortLinkCode(linkDto.getOriginalUrl());
        Link link = Link
                .builder()
                .username(subject)
                .originalUrl(linkDto.getOriginalUrl())
                .code(code)
                .password(linkDto.getPassword())
                .expiredAt(linkDto.getExpireAt())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy(subject)
                .updatedBy(subject)
                .build()
                ;
        linkDao.insertLink(link);
        return code;
    }

    @Override
    public LinkVo getLinkByCode(String code) {
        return null;
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
