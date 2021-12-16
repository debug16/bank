package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.AccountService;
import com.bank.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/user_login")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (!(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(password))) {
            response.sendRedirect(request.getHeader("Refeter"));
            return;
        }

        AccountService as = new AccountService();
        Account account = as.login(name, password);
        if (account != null) {
            request.getSession().setAttribute("user", account);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("failMsg", "用户名或密码错误！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
