package com.gaotianchi.wtf.service.impl;

import com.gaotianchi.wtf.dao.LinkDao;
import com.gaotianchi.wtf.dto.LinkDto;
import com.gaotianchi.wtf.service.LinkService;
import com.gaotianchi.wtf.vo.LinkVo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author gaotianchi
 * @since 2025/2/13 10:50
 **/
@Service("linkService")
public class LinkServiceImpl implements LinkService {

    private final LinkDao linkDao;

    public LinkServiceImpl(LinkDao linkDao) {
        this.linkDao = linkDao;
    }


    @Override
    public String createNewLink(
            String subject,
            LinkDto linkDto
    ) {


        return "";
    }

    @Override
    public LinkVo getLinkByCode(String shortLinkCode) {
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
