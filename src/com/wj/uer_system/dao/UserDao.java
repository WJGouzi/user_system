package com.wj.uer_system.dao;

import com.wj.uer_system.domain.UserBean;

import java.util.List;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.dao
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/20 00:29
 **/
public interface UserDao {

    /**
     * 根据用户账号和密码进行查询
     * @return
     */
    UserBean findUserByUserIdAndPassword(String userId, String password);

    /**
     * 全量搜索用户信息
     * @return
     */
    List<UserBean> findAllUsers();

    /**
     * 插入一条用户的信息
     * @param userBean
     * @return
     */
    Boolean addUser(UserBean userBean);
}
