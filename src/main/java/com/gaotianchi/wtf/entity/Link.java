package com.gaotianchi.wtf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * (Link)
 *
 * @author gaotianchi
 * @since 2025-02-16 10:23:37
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
    private Date expiredAt;
    private String password;
    private Integer userId;
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Integer isDeleted;
}

