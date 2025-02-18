package me._1rr.resource.service;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:19
 **/
public interface CoreService {
    String getOriginalUrl(
            String code,
            String password
    );

    String generateShortLinkCode(String originalUrl);
}
