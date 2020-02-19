package com.wj.uer_system.service.impl;

import com.wj.uer_system.dao.UserDao;
import com.wj.uer_system.dao.impl.UserDaoImpl;
import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.service.UserService;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.service.impl
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/20 00:41
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public UserBean login(String userId, String password) {
        UserBean loginUser = userDao.findUserByUserIdAndPassword(userId, password);
        return loginUser;
    }
}
