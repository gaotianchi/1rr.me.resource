package com.gaotianchi.wtf.service;

import com.gaotianchi.wtf.dto.UserDto;
import com.gaotianchi.wtf.vo.UserVo;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:43
 **/
public interface UserService {
    String createNewUser(UserDto userDto);

    UserVo getUserByUsername(String subject);

    void updateUserByUsername(
            String subject,
            UserDto userDto
    );

    void deleteUserByUsername(String subject);
}
