package com.nysb.demo01.service;

import com.nysb.demo01.entity.User;

import java.util.Map;

public interface UserService {

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String,String> userInfo);

    /**
     * 根据用户手机号和密码查询
     * @param phone
     * @param pwd
     * @return
     */
    String findByPhoneAndPwd(String phone,String pwd);

    /**
     * 根据用户ID查找
     */
    User findByUserId(String id);
}
