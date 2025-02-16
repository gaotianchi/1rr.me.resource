package com.gaotianchi.wtf.service.impl;

import com.gaotianchi.wtf.dto.LinkDto;
import com.gaotianchi.wtf.exception.InvalidPasswordException;
import com.gaotianchi.wtf.exception.LinkExpiredException;
import com.gaotianchi.wtf.exception.LinkNotFoundException;
import com.gaotianchi.wtf.service.CacheService;
import com.gaotianchi.wtf.service.CoreService;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

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

    @Override
    public String generateShortLinkCode(String originalUrl) {
        int hash = Hashing
                .murmur3_32_fixed()
                .hashString(originalUrl, StandardCharsets.UTF_8)
                .asInt()
                ;
        return toBase62(hash).substring(0, 6);
    }

    private String toBase62(int num) {
        String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(CHARSET.charAt(num % 62));
            num /= 62;
        }
        return sb
                .reverse()
                .toString();
    }

    private boolean isLinkExpired(LinkDto linkDto) {
        LocalDateTime expireAt = linkDto.getExpireAt();
        if (expireAt == null) {
            return false;
        }
        return expireAt.isBefore(LocalDateTime.now());
    }

    private boolean isPasswordInvalid(
            String password,
            LinkDto linkDto
    ) {
        return linkDto.getPassword() != null && !linkDto
                .getPassword()
                .equals(password);
    }
}
