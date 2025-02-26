package me._1rr.resource.dao.base;

import me._1rr.resource.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author gaotianchi
 * @since 2025-02-16 15:17:12
 */
@Mapper
public interface UserBaseDao {

    void insertUser(User user);

    void insertUserInBatches(
            @Param("entities") List<User> entities
    );

    void insertOrUpdateUserInBatches(
            @Param("entities") List<User> entities
    );

    void updateUser(User user);

    void deleteUserById(Integer id);

    User selectUserById(Integer id);

    List<User> selectUserByPage(
            @Param("entity") User user,
            @Param("pageable") Pageable pageable
    );

    long count(User user);
}

