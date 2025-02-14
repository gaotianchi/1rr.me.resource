package com.gaotianchi.wtf.dao.base;

import com.gaotianchi.wtf.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gaotianchi
 * @since 2025-02-14 10:50:03
 */
@Mapper
public interface UserBaseDao {

    void insertUser(User user);

    void insertUserInBatches(@Param("entities") List<User> entities);

    void insertOrUpdateUserInBatches(@Param("entities") List<User> entities);

    void updateUser(User user);

    void deleteUserById(Integer id);

    User selectUserById(Integer id);

    List<User> selectUserByPage(@Param("entity") User user, @Param("pageable") Pageable pageable);

    long count(User user);
}

