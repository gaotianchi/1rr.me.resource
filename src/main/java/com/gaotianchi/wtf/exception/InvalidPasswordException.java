package com.gaotianchi.wtf.exception;

/**
 * @author gaotianchi
 * @since 2025/2/16 上午11:54
 **/
public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String code) {
        super(String.format("与 %s 关联的短链接密码错误", code));
    }
}
