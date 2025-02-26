package me._1rr.resource.service.impl;

import com.google.common.hash.Hashing;
import me._1rr.resource.exception.InvalidPasswordException;
import me._1rr.resource.exception.LinkExpiredException;
import me._1rr.resource.exception.LinkNotFoundException;
import me._1rr.resource.service.CacheService;
import me._1rr.resource.service.CoreService;
import me._1rr.resource.vo.LinkCoreVo;
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

        LinkCoreVo linkVo = cacheService.getCoreLinkByCode(code);

        if (linkVo == null) {
            throw new LinkNotFoundException(code);
        }

        if (isLinkExpired(linkVo)) {
            throw new LinkExpiredException(code);
        }

        if (isPasswordInvalid(password, linkVo)) {
            throw new InvalidPasswordException(code);
        }

        return linkVo.getOriginalUrl();
    }

    @Override
    public String generateShortLinkCode(String originalUrl) {
        int hash = Hashing
                .murmur3_32_fixed()
                .hashString(originalUrl, StandardCharsets.UTF_8)
                .asInt()
                ;

        hash = Math.abs(hash);
        StringBuilder base62 = new StringBuilder(toBase62(hash));
        while (base62.length() < 6) {
            base62.insert(0, "0");
        }
        return base62.substring(0, 6);
    }

    private String toBase62(int num) {
        String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        if (num == 0) {
            sb.append(CHARSET.charAt(0));
        } else {
            while (num > 0) {
                sb.append(CHARSET.charAt(num % 62));
                num /= 62;
            }
        }

        return sb
                .reverse()
                .toString();
    }


    private boolean isLinkExpired(LinkCoreVo linkCoreVo) {
        LocalDateTime expireAt = linkCoreVo.getExpiredAt();
        if (expireAt == null) {
            return false;
        }
        return expireAt.isBefore(LocalDateTime.now());
    }

    private boolean isPasswordInvalid(
            String password,
            LinkCoreVo linkVo
    ) {
        return linkVo.getPassword() != null && !linkVo
                .getPassword()
                .equals(password);
    }
}
