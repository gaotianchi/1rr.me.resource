package me._1rr.resource;


import me._1rr.resource.exception.InvalidPasswordException;
import me._1rr.resource.exception.LinkExpiredException;
import me._1rr.resource.exception.LinkNotFoundException;
import org.springframework.dao.DuplicateKeyException;
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

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<String> handleDuplicateKey(DuplicateKeyException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("数据库约束冲突: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("未知异常: " + ex.getMessage());
    }
}

