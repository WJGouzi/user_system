package com.wj.uer_system.dao.impl;

import com.wj.uer_system.dao.UserDao;
import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public UserBean findUserById(int id) {

        try {
            String sql = "select * from t_user where id = ?";
            UserBean userBean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class), id);
            return userBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<UserBean> findAllUsers() {
        try {
            String sql = "select * from t_user";
            List<UserBean> userBeans = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class));
            return userBeans;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean addUser(UserBean userBean) {
        try {
            String sql = "insert into t_user values(null, ?, ?, ?, ?, ?, ?, null, null)";
            jdbcTemplate.update(sql, userBean.getName(), userBean.getGender(), userBean.getAge(), userBean.getAddress(), userBean.getQq(), userBean.getEmail());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUserById(int userId) {
        try {
            String sql = "delete from t_user where id = ?";
            jdbcTemplate.update(sql, userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUserInfo(UserBean userBean) {
        try {
            String sql = "update t_user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
            jdbcTemplate.update(sql, userBean.getName(), userBean.getGender(), userBean.getAge(), userBean.getAddress(), userBean.getQq(), userBean.getEmail(), userBean.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int countAllUsersCount(Map<String, String[]> queryCondition) {
        try {
            String sql = "select count(*) from t_user where 1 = 1";
            StringBuilder sb = new StringBuilder(sql);
            Set<String> keys = queryCondition.keySet();
            List<String> params = new ArrayList<>();
            for (String key: keys) {
                if (key.equals("currentPage") || key.equals("number")) {
                    continue;
                }
                String value = queryCondition.get(key)[0];
                if (value != null && !("".equals(value))) {
                    sb.append(" and " + key + " like ?");
                    params.add("%" + value + "%");
                }
            }
            return jdbcTemplate.queryForObject(sb.toString(), Integer.class, params.toArray());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<UserBean> findUserByPage(int startIndex, int number, Map<String, String[]> queryCondition) {

        try {
            String sql = "select * from t_user where 1 = 1";
            StringBuilder sb = new StringBuilder(sql);
            Set<String> keys = queryCondition.keySet();
            List<Object> params = new ArrayList<>();
            for (String key: keys) {
                if (key.equals("currentPage") || key.equals("number")) {
                    continue;
                }
                String value = queryCondition.get(key)[0];
                if (value != null && !("".equals(value))) {
                    sb.append(" and " + key + " like ?");
                    params.add("%" + value + "%");
                }
            }
            sb.append(" order by id asc");
            sb.append(" limit ?, ?");
            params.add(startIndex);
            params.add(number);
            return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<UserBean>(UserBean.class), params.toArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
