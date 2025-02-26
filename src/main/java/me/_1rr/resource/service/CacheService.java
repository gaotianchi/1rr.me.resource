package me._1rr.resource.service;

import me._1rr.resource.dto.LinkDto;
import me._1rr.resource.vo.LinkCoreVo;

/**
 * @author gaotianchi
 * @since 2025/2/16 上午10:38
 **/
public interface CacheService {

    LinkCoreVo getCoreLinkByCode(String code);

    void updateCoreLinkByCode(LinkDto linkDto);

    void deleteCoreLinkByCode(String code);
}
