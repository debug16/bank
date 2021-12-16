package com.bank.controller;

import com.bank.model.Account;
import com.bank.model.Trade;
import com.bank.service.TradeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TradeListServlet", value = "/trade_list")
public class TradeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account user = (Account) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        TradeService ts = new TradeService();
        List<Trade> tradeList = ts.getAllTradeByAccountId(user.getAccountId());
        request.getSession().setAttribute("tradeList",tradeList);
        response.sendRedirect("trade.jsp");
    }
}
