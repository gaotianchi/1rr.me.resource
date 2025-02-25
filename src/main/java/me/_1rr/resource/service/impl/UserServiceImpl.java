package me._1rr.resource.service.impl;

import me._1rr.resource.dao.UserDao;
import me._1rr.resource.dto.UserDto;
import me._1rr.resource.entity.User;
import me._1rr.resource.service.UserService;
import me._1rr.resource.vo.UserVo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:43
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String registerUser(UserDto userDto) {
        Integer useThirdPartyLogin = userDto.getUseThirdPartyLogin();
        String username = userDto.getUsername();
        User user = User
                .builder()
                .username(username)
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .useThirdPartyLogin(useThirdPartyLogin)
                .emailIsVerified(userDto.getEmailIsVerified())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build()
                ;
        try {
            userDao.insertUser(user);
        } catch (DuplicateKeyException e) {
            return username;
        }
        return username;
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
