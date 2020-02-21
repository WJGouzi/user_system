package com.wj.uer_system.service.impl;

import com.wj.uer_system.dao.UserDao;
import com.wj.uer_system.dao.impl.UserDaoImpl;
import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.service.UserService;

import java.util.List;

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

    @Override
    public List<UserBean> findAll() {
        List<UserBean> userBeans = userDao.findAllUsers();
        return userBeans;
    }

    @Override
    public UserBean findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public Boolean addUser(UserBean userBean) {
        return userDao.addUser(userBean);
    }

    @Override
    public boolean deleteUserById(String id) {
        //首先查找用户的信息
        UserBean userBean = this.findUserById(id);
        if (userBean == null) {
            return false;
        }
        return userDao.deleteUserById(Integer.parseInt(id));
    }

    @Override
    public boolean updateUserInfo(UserBean userBean) {

        return userDao.updateUserInfo(userBean);

    }
}
