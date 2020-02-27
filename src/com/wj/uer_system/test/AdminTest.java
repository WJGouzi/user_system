package com.wj.uer_system.test;

import com.wj.uer_system.domain.AdminUserBean;
import com.wj.uer_system.service.AdminService;
import com.wj.uer_system.service.impl.AdminServiceImpl;
import org.junit.Test;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.test
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/27 21:57
 **/
public class AdminTest {

    private AdminService adminService = new AdminServiceImpl();
    /**
     * 插入admin
     */
    @Test
    public void addAdminUser() {
        AdminUserBean adminUserBean = new AdminUserBean();
        adminUserBean.setName("王钧");
        adminUserBean.setGender("男");
        adminUserBean.setPassword("123");
        adminUserBean.setUserId("wj");
        adminUserBean.setIdCard("510603199105211350");
        AdminUserBean bean = adminService.addAdminUser(adminUserBean);
        System.out.println(bean);
    }

}
