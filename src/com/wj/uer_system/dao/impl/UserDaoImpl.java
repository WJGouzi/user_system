package com.wj.uer_system.dao.impl;

import com.wj.uer_system.dao.UserDao;
import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.dao.impl
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/20 00:30
 **/
public class UserDaoImpl implements UserDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public UserBean findUserByUserIdAndPassword(String userId, String password) {
        try {
            String sql = "select * from t_user where user_id = ? and password = ?";
            UserBean userBean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class), userId, password);
            return userBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
