package me._1rr.resource.service;

import me._1rr.resource.dto.UserDto;
import me._1rr.resource.vo.UserVo;

/**
 * @author gaotianchi
 * @since 2025/2/15 下午5:43
 **/
public interface UserService {

    /**
     * 该方法适用于登记用户，如果用户已经存在，则返回已存在的用户名
     * @author gaotianchi
     * @since 2025/2/24 下午5:32
     * @param userDto UserDto
     * @return java.lang.String 用户名
     **/
    String registerUser(UserDto userDto);

    UserVo getUserByUsername(String subject);

    void updateUserByUsername(
            String subject,
            UserDto userDto
    );

    void deleteUserByUsername(String subject);
}
