package com.bank.controller;

import com.bank.model.Account;
import com.bank.model.Trade;
import com.bank.service.AccountService;
import com.bank.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "TransferServlet", value = "/transfer")
public class TransferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取用户信息 也是判断一下用户是否登录
        Account account = (Account) request.getSession().getAttribute("user");
        if (account == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        //获取参数信息
        String money = request.getParameter("money");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        String digest = request.getParameter("digest");

        AccountService ts = new AccountService();
        //如果参数有一个为空
        if (!(StringUtils.isNotEmpty(money) &&
                StringUtils.isNotEmpty(password) &&
                StringUtils.isNotEmpty(type))) {
            request.getRequestDispatcher("transfer.jsp").forward(request, response);
            return;
        }

        //封装交易数据
        Trade trade = new Trade();
        trade.setAccountId(account.getAccountId());
        trade.setTradeType(Integer.parseInt(type));
        trade.setTradeMoney(Double.parseDouble(money));
        trade.setTradeDigest(digest);
        trade.setTradeTime(new Date());

        boolean flag = false;
        //存款和取款
        if (trade.getTradeType() == 1 || trade.getTradeType() == 2) {
            flag = ts.depositAndWithd(account.getAccountId(), password, trade);
        } else if (trade.getTradeType() == 3) { //转账
            String toAccount = request.getParameter("toAccount");
            if (!(StringUtils.isNotEmpty(toAccount)) || account.getAccountId().equals(toAccount)) { //转入为空或者转入转出是一个账户
                request.setAttribute("failMsg", "不能向自己转账！");
                request.getRequestDispatcher("transfer.jsp").forward(request, response);
                return;
            }
            flag = ts.transfer(account.getAccountId(), password, toAccount, trade);
        }

        if (flag) {
            request.setAttribute("msg", "交易成功！");
        } else {
            if (trade.getTradeType() == 3) {
                request.setAttribute("failMsg", "交易失败！请检查密码是否正确，转入账户是否存在，余额是否充足!!!");
            }else {
                request.setAttribute("failMsg", "交易失败！请检查密码是否正确，余额是否充足!!!");
            }
        }
        if (trade.getTradeType() == 3) {
            request.getRequestDispatcher("transfer.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("access.jsp").forward(request, response);
        }

    }
}
