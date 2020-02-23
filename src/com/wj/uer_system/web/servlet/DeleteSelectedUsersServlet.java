package com.wj.uer_system.web.servlet;

import com.wj.uer_system.service.UserService;
import com.wj.uer_system.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Project : user_system
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/22 21:41
 * 删除所选用户的servlet
 **/
@WebServlet("/deleteSelectedUsersServlet")
public class DeleteSelectedUsersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String[] selectedUserIds = request.getParameterValues("selectedUserId");
        UserService userService = new UserServiceImpl();
        boolean flag = userService.deleteUserByIds(selectedUserIds);
        if (flag) {
            /// 删除完成后进行重定向
            response.sendRedirect(request.getContextPath() + "/allUserListServlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
