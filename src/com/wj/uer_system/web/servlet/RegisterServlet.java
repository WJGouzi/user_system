package com.wj.uer_system.web.servlet;

import com.wj.uer_system.domain.AdminUserBean;
import com.wj.uer_system.service.AdminService;
import com.wj.uer_system.service.impl.AdminServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Project : user_system
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/27 20:21
 **/
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCodeNumber");
        session.removeAttribute("checkCodeNumber");
        String verifycode = request.getParameter("verifycode");
        if (!(checkCode != null && checkCode.equalsIgnoreCase(verifycode))) {
            request.setAttribute("loginError", "验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap = new HashMap<>(request.getParameterMap());
        for (String key: parameterMap.keySet()) {
            if (key.equals("verifycode")) {
                parameterMap.remove(key);
                break;
            }
        }
        // 获取两次的密码是否一致
        String password = parameterMap.get("password")[0];
        String checkPassword = parameterMap.get("checkPassword")[0];
        if (password.equals(checkPassword)) {
            parameterMap.remove("checkPassword");
        } else {
            request.setAttribute("loginError", "您两次输入的密码有误，请核对");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        AdminUserBean adminUserBean = new AdminUserBean();
        try {
            BeanUtils.populate(adminUserBean, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        if (adminUserBean != null) {
            // 注册成功
            AdminService adminService = new AdminServiceImpl();
            AdminUserBean finalBean = adminService.addAdminUser(adminUserBean);
            session.setAttribute("adminInfo", finalBean);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } else  {
            request.setAttribute("loginError", "注册失败重新注册");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
