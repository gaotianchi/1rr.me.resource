package entity;

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
 * @since 2025-02-15 21:41:08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Link implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String shortUrl;
    private String originalUrl;
    private Integer userId;
    private Date expiredAt;
    private Integer id;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private String createdBy;
    private String updatedBy;
    private String deletedBy;
    private Integer isDeleted;
}

