package me._1rr.resource.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author gaotianchi
 * @since 2025/2/15 16:30
 **/

@Data
@Builder
public class LinkVo {
    private String code;
    private String originalUrl;
    private LocalDateTime expiredAt;
    private String password;
    private String username;
    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Integer isDeleted;
}
