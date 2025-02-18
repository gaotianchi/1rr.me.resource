package me._1rr.resource.service.impl;

import me._1rr.resource.dto.UserDto;
import me._1rr.resource.service.UserService;
import me._1rr.resource.vo.UserVo;
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
