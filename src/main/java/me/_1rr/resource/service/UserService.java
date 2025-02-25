package me._1rr.resource.service;

import me._1rr.resource.dto.UserDto;
import me._1rr.resource.vo.UserVo;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:43
 **/
public interface UserService {
    String registerUser(UserDto userDto);

    UserVo getUserByUsername(String subject);

    void updateUserByUsername(
            String subject,
            UserDto userDto
    );

    void deleteUserByUsername(String subject);
}
