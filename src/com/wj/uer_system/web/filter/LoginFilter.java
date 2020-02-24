package com.wj.uer_system.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Project : user_system
 * @Package : ${PACKAGE_NAME}
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/24 23:22
 **/
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/login.jsp") || requestURI.contains("/loginServlet") || requestURI.contains("/newCheckCodeServlet") || requestURI.contains("/css/") || requestURI.contains("/js/") || requestURI.contains("/fonts/")) {
            chain.doFilter(req, resp);
        } else {
            Object user = request.getSession().getAttribute("userInfo");
            if (user != null) {
                chain.doFilter(req, resp);
            } else  {
                request.setAttribute("loginError", "您还未登录，先请登录!");
                request.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
