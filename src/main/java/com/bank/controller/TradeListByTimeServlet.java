package com.bank.controller;

import com.bank.model.Account;
import com.bank.model.Page;
import com.bank.model.Trade;
import com.bank.service.TradeService;

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
        Account user = (Account) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        //初始化默认值
        int pageNumber = 1;
        Page page = null;

        //获取参数
        String tempPageNumber = request.getParameter("pageNumber");

        //如果传了就赋值
        if (tempPageNumber != null && !"".equals(tempPageNumber)) {
            //防止页码小于1
            pageNumber = Integer.parseInt(tempPageNumber) <= 0 ? 1 : Integer.parseInt(tempPageNumber);
        }

        TradeService ts = new TradeService();
        page = ts.selectPageBytime(pageNumber, user.getAccountId(), startTime, endTime);
        request.setAttribute("type", 1);
        request.setAttribute("startTime",startTime);
        request.setAttribute("endTime",endTime);
        request.getSession().setAttribute("p", page);
        request.getRequestDispatcher("trade.jsp").forward(request, response);

    }
}
