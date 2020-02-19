package com.wj.uer_system.service;

import com.wj.uer_system.domain.UserBean;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.service
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/20 00:40
 **/
public interface UserService {

    UserBean login(String userId, String password);

}
