package me._1rr.resource.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author gaotianchi
 * @since 2025/2/25 下午4:41
 **/
@Data
@Builder
public class LinkCoreVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String code;
    private String originalUrl;
    private LocalDateTime expiredAt;
    private String password;
    private String username;
}