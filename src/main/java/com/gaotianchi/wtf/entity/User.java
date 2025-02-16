package com.gaotianchi.wtf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * (User)
 *
 * @author gaotianchi
 * @since 2025-02-16 10:13:18
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
    private Integer useThirdPartyLogin;
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Integer isDeleted;
}

