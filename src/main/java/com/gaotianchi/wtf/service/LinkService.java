package com.gaotianchi.wtf.service;


import com.gaotianchi.wtf.dto.LinkDto;
import com.gaotianchi.wtf.vo.LinkVo;
import org.springframework.data.domain.Page;

/**
 * @author gaotianchi
 * @since 2025/2/13 9:23
 **/
public interface LinkService {

    String createNewLink(
            String subject,
            LinkDto linkDto
    );

    LinkVo getLinkByCode(String shortLinkCode);

    Page<LinkVo> getPageLinks(
            String subject,
            LinkDto linkDto
    );

    void updateLinkByCode(
            String shortLinkCode,
            LinkDto linkDto
    );

    void deleteLinkByCode(String shortLinkCode);
}
