package com.wj.uer_system.service.impl;

import com.wj.uer_system.dao.UserDao;
import com.wj.uer_system.dao.impl.UserDaoImpl;
import com.wj.uer_system.domain.PageBean;
import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.service.impl
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/20 00:41
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public UserBean login(String userId, String password) {
        UserBean loginUser = userDao.findUserByUserIdAndPassword(userId, password);
        return loginUser;
    }

    @Override
    public List<UserBean> findAll() {
        List<UserBean> userBeans = userDao.findAllUsers();
        return userBeans;
    }

    @Override
    public UserBean findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public Boolean addUser(UserBean userBean) {
        return userDao.addUser(userBean);
    }

    @Override
    public boolean deleteUserById(String id) {
        //首先查找用户的信息
        UserBean userBean = this.findUserById(id);
        if (userBean == null) {
            return false;
        }
        return userDao.deleteUserById(Integer.parseInt(id));
    }

    @Override
    public boolean deleteUserByIds(String[] selectedUserIds) {
        boolean flag = true;
        for (String id: selectedUserIds) {
            // 这里需要考虑到的是如果批量删除出现错误的时候，数据库要回滚
            flag = userDao.deleteUserById(Integer.parseInt(id));
            if (flag == false) {
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean updateUserInfo(UserBean userBean) {

        return userDao.updateUserInfo(userBean);

    }

    @Override
    public PageBean<UserBean> findUserByPage(String _currentPage, String _number, Map<String, String[]> _queryCondition) {

        int currentPage = Integer.parseInt(_currentPage);
        int number = Integer.parseInt(_number);

        PageBean<UserBean> pageBean = new PageBean<>();
        // 查询所有的数据
        int totalCount = userDao.countAllUsersCount(_queryCondition);
        pageBean.setTotalCount(totalCount);
        int totalPage = new Double(Math.ceil(new Double(totalCount) / new Double(number))).intValue();
        pageBean.setTotalPage(totalPage);
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        if (currentPage <= 0) {
            currentPage = 1;
        }
        pageBean.setCurrentPage(currentPage);
        pageBean.setNumber(number);
        // 有条件的查询
        int startIndex = (currentPage - 1) * number;
        List<UserBean> users = userDao.findUserByPage(startIndex, number, _queryCondition);
        pageBean.setBeanList(users);
        return pageBean;
    }

}
