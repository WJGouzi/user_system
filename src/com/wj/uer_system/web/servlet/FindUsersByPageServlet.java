package com.wj.uer_system.web.servlet;

import com.wj.uer_system.domain.PageBean;
import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.service.UserService;
import com.wj.uer_system.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Project : user_system
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/22 22:26
 * 通过分页进行查找用户信息
 **/
@WebServlet("/findUsersByPageServlet")
public class FindUsersByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 拿到每页的条数和第几页
        String currentPage = request.getParameter("currentPage");
        String number = request.getParameter("number");
        // 没有的话就设置一个默认值
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }

        if (number == null || "".equals(number)) {
            number = "5";
        }

        Map<String, String[]> queryCondition = request.getParameterMap();
        UserService userService = new UserServiceImpl();
        PageBean<UserBean> pageBean = userService.findUserByPage(currentPage, number, queryCondition);

        System.out.println(pageBean);
        // 转发
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("condition", queryCondition);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
