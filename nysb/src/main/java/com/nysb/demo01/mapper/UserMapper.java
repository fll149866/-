package com.nysb.demo01.mapper;

import com.nysb.demo01.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int save(User user);

    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    User findByUserId(@Param("user_id") String user_id);
}
