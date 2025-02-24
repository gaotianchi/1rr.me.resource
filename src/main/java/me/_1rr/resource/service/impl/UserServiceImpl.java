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

    /**
     * 规范化用户名
     *
     * @param rawUsername 原始用户名
     * @return 规范化后的用户名
     */
    private String normalizeUsername(String rawUsername) {
        if (rawUsername == null || rawUsername.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        String normalized = rawUsername.toLowerCase();
        normalized = normalized.replaceAll("\\s+", "_");
        normalized = normalized.replaceAll("[^a-z0-9_]", "");
        long timestamp = System.currentTimeMillis() / 1000;
        normalized = normalized + "_" + timestamp;
        return normalized;
    }

    @Override
    public String createNewUser(UserDto userDto) {
        Integer useThirdPartyLogin = userDto.getUseThirdPartyLogin();
        String username = userDto.getUsername();
        if (useThirdPartyLogin != null && useThirdPartyLogin == 1) {
            username = normalizeUsername(username);
        }
        User user = User
                .builder()
                .username(username)
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .useThirdPartyLogin(useThirdPartyLogin)
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
