package com.bank.controller;

import com.bank.model.Account;
import com.bank.service.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BalanceServlet", value = "/balance")
public class BalanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取登录的用户
        Account account = (Account) request.getSession().getAttribute("user");

        if (account == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        double money = 0;
        try {
            money = new AccountService().getMoney(account.getAccountId());
            request.setAttribute("balance", money);
            request.getRequestDispatcher("balance.jsp").forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("failMsg", "查询余额失败！");
        request.getRequestDispatcher("balance.jsp").forward(request, response);
    }
}
