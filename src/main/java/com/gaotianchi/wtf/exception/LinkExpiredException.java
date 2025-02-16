package com.gaotianchi.wtf.exception;

/**
 * @author gaotianchi
 * @since 2025/2/16 上午11:51
 **/
public class LinkExpiredException extends RuntimeException {
    public LinkExpiredException(String code) {
        super(String.format("与 %s 关联的短链接已过期", code));
    }
}
