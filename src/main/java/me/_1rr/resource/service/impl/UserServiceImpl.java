package me._1rr.resource.service.impl;

import me._1rr.resource.dao.UserDao;
import me._1rr.resource.dto.UserDto;
import me._1rr.resource.entity.User;
import me._1rr.resource.service.UserService;
import me._1rr.resource.vo.UserVo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

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
    public String createNewUser(UserDto userDto) {
        User user = User
                .builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .useThirdPartyLogin(userDto.getUseThirdPartyLogin())
                .build()
                ;
        try {
            userDao.insertUser(user);
        } catch (DuplicateKeyException e) {
            return userDto.getUsername();
        }
        return userDto.getUsername();
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
