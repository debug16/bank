package com.bank.filter;

import com.bank.model.Account;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",
        servletNames = {
                "TransferServlet", "TradeListByTimeServlet", "TradeListServlet", "TransferServlet"
        },
        value = {
                "/index.jsp",
                "/transfer.jsp",
                "/access.jsp"
        })
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

        if (user == null) {
            resp.sendRedirect("login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}
