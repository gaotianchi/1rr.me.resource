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

    public interface CreateUser extends Default {
    }

    private String username;
    private String password;

    @NotBlank(groups = {CreateUser.class})
    private Integer emailIsVerified;

    @NotBlank(groups = {CreateUser.class})
    @Email(groups = {CreateUser.class})
    private String email;

    private Integer useThirdPartyLogin;
}
