package me._1rr.resource.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gaotianchi
 * @since 2025/2/16 上午11:37
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException(String code) {
        super(String.format("与 %s 关联的短链接不存在", code));
    }
}
