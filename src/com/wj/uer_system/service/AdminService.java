package com.wj.uer_system.service;

import com.wj.uer_system.domain.AdminUserBean;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.service
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/27 21:37
 **/
public interface AdminService {
    /**
     * 添加管理员
     * @param adminUserBean
     * @return
     */
    AdminUserBean addAdminUser(AdminUserBean adminUserBean);

    /**
     * 通过id找到管理员用户
     * @param userName
     * @return
     */
    AdminUserBean findAdiminByUserId(String userName);
}
