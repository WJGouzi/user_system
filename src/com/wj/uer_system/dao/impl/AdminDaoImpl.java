package com.wj.uer_system.dao.impl;

import com.wj.uer_system.dao.AdminDao;
import com.wj.uer_system.domain.AdminUserBean;
import com.wj.uer_system.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.dao.impl
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/27 21:39
 **/
public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public boolean addAdminUser(AdminUserBean adminUserBean) {
        try {
            //String sql = "insert into t_user values(null, ?, ?, ?, ?, ?, ?, null, null)";
            String sql = "insert into t_admin values(null, ?, ?, null, null, null, null, ?, ?, ?)";
            jdbcTemplate.update(sql, adminUserBean.getName(), adminUserBean.getGender(), adminUserBean.getUserId(), adminUserBean.getPassword(), adminUserBean.getIdCard());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public AdminUserBean findAdminUserByUserId(String userId) {
        try {
            String sql = "select * from t_admin where user_id = ?";
            AdminUserBean adminUserBean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<AdminUserBean>(AdminUserBean.class), userId);
            return adminUserBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
