package me._1rr.resource.service;


import me._1rr.resource.dto.LinkDto;
import me._1rr.resource.vo.LinkCoreVo;
import me._1rr.resource.vo.LinkVo;
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

    LinkCoreVo getLinkByCode(String shortLinkCode);

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
