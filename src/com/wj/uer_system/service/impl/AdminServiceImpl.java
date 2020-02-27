package com.wj.uer_system.service.impl;

import com.wj.uer_system.dao.AdminDao;
import com.wj.uer_system.dao.impl.AdminDaoImpl;
import com.wj.uer_system.domain.AdminUserBean;
import com.wj.uer_system.service.AdminService;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.service.impl
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/27 21:37
 **/
public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public AdminUserBean addAdminUser(AdminUserBean adminUserBean) {
        boolean flag = adminDao.addAdminUser(adminUserBean);
        if (flag) {
            AdminUserBean newAdminUserBean = adminDao.findAdminUserByUserId(adminUserBean.getUserId());
            return newAdminUserBean;
        } else {
            return null;
        }
    }

    @Override
    public AdminUserBean findAdiminByUserId(String userName) {
        return adminDao.findAdminUserByUserId(userName);
    }
}
