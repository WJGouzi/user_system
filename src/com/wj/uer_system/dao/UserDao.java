package com.wj.uer_system.dao;

import com.wj.uer_system.domain.UserBean;

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

}
