package com.bank.controller;

import com.bank.model.Account;
import com.bank.model.Trade;
import com.bank.service.TradeService;
import com.bank.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TradeListByTimeServlet", value = "/tradeList_byTime")
public class TradeListByTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");

        Account user = (Account) request.getSession().getAttribute("user");
        if (user == null || !StringUtils.isNotEmpty(startTime) || !StringUtils.isNotEmpty(endTime)) {
            response.sendRedirect("login.jsp");
            return;
        }

        TradeService ts = new TradeService();
        List<Trade> tradeList = ts.getBetweenTime(user.getAccountId(), startTime, endTime);
        request.getSession().setAttribute("tradeList",tradeList);
        response.sendRedirect("trade.jsp");

    }
}
