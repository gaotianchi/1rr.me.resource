package com.gaotianchi.wtf.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author gaotianchi
 * @since 2025/2/15 15:26
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LinkDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @NotBlank(groups = {AddNewLinkGroup.class}, message = "原始URL不能为空")
    @URL(groups = {AddNewLinkGroup.class}, message = "URL格式无效")
    private String originalUrl;
    @Future(groups = {AddNewLinkGroup.class}, message = "过期时间必须是将来的时间")
    private String expireAt;
    @Size(groups = {AddNewLinkGroup.class}, min = 8, message = "密码长度至少为8个字符")
    private String password;

    public interface AddNewLinkGroup extends Default {
    }
}
