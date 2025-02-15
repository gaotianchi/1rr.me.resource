package com.gaotianchi.wtf.service.impl;

import com.gaotianchi.wtf.dto.UserDto;
import com.gaotianchi.wtf.service.UserService;
import com.gaotianchi.wtf.vo.UserVo;
import org.springframework.stereotype.Service;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:43
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public String createNewUser(UserDto userDto) {
        return "";
    }

    @Override
    public UserVo getUserByUsername(String subject) {
        return null;
    }

    @Override
    public void updateUserByUsername(
            String subject,
            UserDto userDto
    ) {

    }

    @Override
    public void deleteUserByUsername(String subject) {

    }
}
