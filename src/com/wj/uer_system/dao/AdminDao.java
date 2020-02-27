package com.wj.uer_system.dao;

import com.wj.uer_system.domain.AdminUserBean;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.dao
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/27 21:39
 **/
public interface AdminDao {

    /**
     * 添加管理员
     * @param adminUserBean
     */
    boolean addAdminUser(AdminUserBean adminUserBean);

    /**
     * 根据UserId找到相关的用户信息
     * @param userId
     * @return
     */
    AdminUserBean findAdminUserByUserId(String userId);
}
