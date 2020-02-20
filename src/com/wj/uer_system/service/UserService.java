package com.wj.uer_system.service;

import com.wj.uer_system.domain.UserBean;

import java.util.List;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.service
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/20 00:40
 **/
public interface UserService {
    /**
     * 登录的操作
     * @param userId 用户的id
     * @param password 用户密码
     * @return
     */
    UserBean login(String userId, String password);

    /**
     * 查找所有的用户信息
     * @return
     */
    List<UserBean> findAll();

    /**
     * 添加用户
     * @param userBean
     * @return
     */
    Boolean addUser(UserBean userBean);
}
