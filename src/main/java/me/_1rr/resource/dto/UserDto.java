package me._1rr.resource.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.groups.Default;
import lombok.Data;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:40
 **/
@Data
public class UserDto {

    @NotBlank(groups = {RegisterUserGroup.class})
    @Email(groups = {RegisterUserGroup.class})
    private String email;

    private String username;
    private String password;
    private Integer emailIsVerified;
    private Integer useThirdPartyLogin;
    public interface RegisterUserGroup extends Default {
    }
}
