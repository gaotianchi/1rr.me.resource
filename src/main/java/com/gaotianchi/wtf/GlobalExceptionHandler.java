package com.gaotianchi.wtf;


import com.gaotianchi.wtf.exception.InvalidPasswordException;
import com.gaotianchi.wtf.exception.LinkExpiredException;
import com.gaotianchi.wtf.exception.LinkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author gaotianchi
 * @since 2025/2/16 下午12:02
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LinkExpiredException.class)
    public ResponseEntity<String> handleLinkExpired(LinkExpiredException ex) {
        return ResponseEntity
                .status(HttpStatus.GONE)
                .body("链接已经过期: " + ex.getMessage());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<String> handleLinkNotFound(LinkNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("没有找到链接: " + ex.getMessage());
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<String> handleInvalidPassword(InvalidPasswordException ex) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("无效密码: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("未知异常: " + ex.getMessage());
    }
}

