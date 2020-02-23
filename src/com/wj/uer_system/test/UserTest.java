package com.wj.uer_system.test;

import com.wj.uer_system.domain.PageBean;
import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.service.UserService;
import com.wj.uer_system.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.test
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/20 00:43
 **/
public class UserTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void loginTest() {
        UserBean wangjun = userService.login("wangjun", "123456");
        System.out.println(wangjun);
    }

    @Test
    public void findAllUsers() {
        List<UserBean> allUsers = userService.findAll();
        System.out.println(allUsers);
    }

    @Test
    public void addUser() {
        UserBean userBean = new UserBean(null, "黄思盛", "男", 24, "德阳市", "1234342", "huangsisheng@qq.com", null, null);
        Boolean flag = userService.addUser(userBean);
        System.out.println(flag);
    }

    @Test
    public void deleteUserById() {
        boolean flag = userService.deleteUserById("13");
        System.out.println(flag);
    }

    @Test
    public void updateUserInfo() {
        UserBean userBean = new UserBean(13, "黄思盛", "男", 25, "德阳", "55231213", "huangsisheng@qq.com", null, null);
        userService.updateUserInfo(userBean);
    }

    @Test
    public void countAllUserNumber () {
        PageBean<UserBean> pageBean = userService.findUserByPage("1", "5", new HashMap<>());
        System.out.println(pageBean);
    }
}
