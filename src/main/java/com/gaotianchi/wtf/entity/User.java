package com.gaotianchi.wtf.entity;

import java.util.Date;
import java.io.Serial;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gaotianchi
 * @since 2025-02-14 11:33:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String email;
    private Integer emailIsVerified;
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Integer isDeleted;
}

