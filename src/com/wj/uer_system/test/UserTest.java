package com.wj.uer_system.test;

import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.service.UserService;
import com.wj.uer_system.service.impl.UserServiceImpl;
import org.junit.Test;

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
}
