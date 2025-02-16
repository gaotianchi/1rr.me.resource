package com.gaotianchi.wtf.service.impl;

import com.gaotianchi.wtf.dto.LinkDto;
import com.gaotianchi.wtf.exception.InvalidPasswordException;
import com.gaotianchi.wtf.exception.LinkExpiredException;
import com.gaotianchi.wtf.exception.LinkNotFoundException;
import com.gaotianchi.wtf.service.CacheService;
import com.gaotianchi.wtf.service.CoreService;
import org.springframework.stereotype.Service;

import java.time.Instant;

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

    private static boolean isPasswordInvalid(
            String password,
            LinkDto linkDto
    ) {
        return linkDto.getPassword() != null && !linkDto
                .getPassword()
                .equals(password);
    }

    @Override
    public String getOriginalUrl(
            String code,
            String password
    ) {

        LinkDto linkDto = cacheService.getCoreLinkByCode(code);

        if (linkDto == null) {
            throw new LinkNotFoundException(code);
        }

        if (isLinkExpired(linkDto)) {
            throw new LinkExpiredException(code);
        }

        if (isPasswordInvalid(password, linkDto)) {
            throw new InvalidPasswordException(code);
        }

        return linkDto.getOriginalUrl();
    }

    private boolean isLinkExpired(LinkDto linkDto) {
        if (linkDto.getExpireAt() == 0) {
            return false;
        }
        return Instant
                .ofEpochMilli(linkDto.getExpireAt())
                .isBefore(Instant.now());
    }
}
