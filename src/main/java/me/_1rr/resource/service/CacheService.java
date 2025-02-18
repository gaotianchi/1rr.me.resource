package me._1rr.resource.service;

import me._1rr.resource.dto.LinkDto;

/**
 * @author gaotianchi
 * @since 2025/2/16 上午10:38
 **/
public interface CacheService {

    LinkDto getCoreLinkByCode(String code);

    void updateCoreLinkByCode(LinkDto linkDto);

    void deleteCoreLinkByCode(String code);
}
