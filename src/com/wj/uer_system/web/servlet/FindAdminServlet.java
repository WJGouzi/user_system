package com.wj.uer_system.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wj.uer_system.domain.AdminUserBean;
import com.wj.uer_system.service.AdminService;
import com.wj.uer_system.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project : user_system
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/27 22:13
 **/
@WebServlet("/findAdminServlet")
public class FindAdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String userName = request.getParameter("userName");
        AdminService adminService = new AdminServiceImpl();
        AdminUserBean adminUserBean = adminService.findAdiminByUserId(userName);
        Map<String, Object> map = new HashMap<>();
        if (adminUserBean != null) {
            map.put("existFlag" , 1);
        } else  {
            map.put("existFlag", 0);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(map);
        response.getWriter().print(s);
        System.out.println(s);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
