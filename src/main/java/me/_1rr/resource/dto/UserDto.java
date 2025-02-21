package me._1rr.resource.dto;

import lombok.Data;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:40
 **/
@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
    private Integer useThirdPartyLogin;
}
