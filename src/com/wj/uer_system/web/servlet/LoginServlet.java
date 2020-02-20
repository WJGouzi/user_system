package com.wj.uer_system.web.servlet;

import com.wj.uer_system.domain.UserBean;
import com.wj.uer_system.service.UserService;
import com.wj.uer_system.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Project : user_system
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/20 00:26
 **/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 拿到参数登录成功后进入到listServlet去，
        // 如果失败就直接返回到之前的界面去。
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCodeNumber");
        session.removeAttribute("checkCodeNumber");
        String verifycode = request.getParameter("verifycode");
        if (!(checkCode != null && checkCode.equalsIgnoreCase(verifycode))) {
            request.setAttribute("loginError", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        UserBean userBean = new UserBean();
        userBean.setUserId(userId);
        userBean.setPassword(password);
        UserBean user = userService.login(userBean.getUserId(), userBean.getPassword());
        System.out.println(user);
        if (user != null) {
            session.setAttribute("userInfo", user);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } else  {
            request.setAttribute("loginError", "账号或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
