package me._1rr.resource.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Link)
 *
 * @author gaotianchi
 * @since 2025-02-16 15:17:11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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

