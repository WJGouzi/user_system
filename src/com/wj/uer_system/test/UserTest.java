package com.wj.uer_system.test;

import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.service.UserService;
import com.wj.uer_system.service.impl.UserServiceImpl;
import org.junit.Test;

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
}
