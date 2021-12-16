package com.bank.filter;

import com.bank.model.Account;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", value = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        Account user = (Account) req.getSession().getAttribute("user");

        System.out.println("req.getServletPath() = " + req.getServletPath());
        System.out.println("req.getContextPath() = " + req.getContextPath());

//        if (req.getServletPath().equals("/login.jsp") || req.getServletPath().equals("/user_login")) {
//            System.out.println(1);
//            chain.doFilter(request, response);
//        } else if (user != null) {
//            System.out.println(2);
//            chain.doFilter(request, response);
//        } else {
//            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            chain.doFilter(request, response);
//            System.out.println(3);
//        }
        //登录了，就不拦截了
//        if (req.getServletPath().equals("/login.jsp") || req.getServletPath().equals("/user_login")) {
//            chain.doFilter(request, response);
//        } else if (user == null) { //登录页面和登录的接口不需要拦截
////            resp.sendRedirect("login.jsp");
//            req.getRequestDispatcher("login.jsp").forward(request, response);
//        } else { //没有登录就拦截
//            chain.doFilter(request, response);
//        }
    }
}
