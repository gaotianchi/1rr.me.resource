package com.gaotianchi.wtf.service.impl;

import com.gaotianchi.wtf.dto.LinkDto;
import com.gaotianchi.wtf.service.CacheService;
import com.gaotianchi.wtf.service.CoreService;
import org.springframework.stereotype.Service;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:23
 **/
@Service("CoreService")
public class CoreServiceImpl implements CoreService {

    private final CacheService cacheService;

    public CoreServiceImpl(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public String getOriginalUrl(
            String code,
            String password
    ) {

        LinkDto linkDto = cacheService.getCoreLinkByCode(code);

        return "";
    }
}
