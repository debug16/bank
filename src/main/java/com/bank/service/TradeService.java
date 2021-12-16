package com.bank.service;

import com.bank.dao.TradeDao;
import com.bank.model.Page;
import com.bank.model.Trade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Debug16
 * @version 1.0
 * @description: 交易信息服务层
 * @date 2021/12/16 下午 6:51
 */
public class TradeService {
    private final TradeDao td = new TradeDao();

    public boolean addTrade(Connection cn, Trade trade) {
        try {
            if (cn != null && !cn.isClosed())
                return td.addTrade(cn, trade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Page selectPageByAccountID(int pageNumber, String accountId) {

        Page page = new Page();
        //初始化默认一页多少数量
        int pageSize = 10;
        //设置页码
        page.setPageNumber(pageNumber);
        //对页码进行处理 好给Dao操作
        pageNumber = (pageNumber - 1) * pageSize;
        //总数量
        int totalcount = 0;

        //获取指定的类型商品数量
        try {
            totalcount = td.getCountByAccountId(accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取一共好多页
        int totalPage = totalcount >= pageSize ? (int) (Math.ceil((double) totalcount / pageSize)) : 1;

        //防止用户输入的页码大于总页码
        if (page.getPageNumber() > totalPage) {
            page.setPageNumber(totalPage);
            pageNumber = (totalPage - 1) * pageSize;
        }

        //设置一页数量和总数量
        page.SetPageSizeAndTotalCount(pageSize, totalcount);
        //设置总页数
        page.setTotalPage(totalPage);
        List tradeList = null;
        try {
            //获取指定页的商品信息
            tradeList = td.selectPageByAccountId(pageNumber, pageSize, accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //封装到集合
        page.setList(tradeList);
        return page;
    }

    public Page selectPageBytime(int pageNumber, String accountId, String t1, String t2) {
        Page page = new Page();
        //初始化默认一页多少数量
        int pageSize = 10;
        //设置页码
        page.setPageNumber(pageNumber);
        //对页码进行处理 好给Dao操作
        pageNumber = (pageNumber - 1) * pageSize;
        //总数量
        int totalcount = 0;

        //获取指定的类型商品数量
        try {
            totalcount = td.getCountByTime(accountId,t1,t2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //获取一共好多页
        int totalPage = totalcount >= pageSize ? (int) (Math.ceil((double) totalcount / pageSize)) : 1;

        //防止用户输入的页码大于总页码
        if (page.getPageNumber() > totalPage) {
            page.setPageNumber(totalPage);
            pageNumber = (totalPage - 1) * pageSize;
        }

        //设置一页数量和总数量
        page.SetPageSizeAndTotalCount(pageSize, totalcount);
        //设置总页数
        page.setTotalPage(totalPage);
        List tradeList = null;
        try {
            //获取指定页的商品信息
            tradeList = td.getBetweenTime(pageNumber, pageSize, accountId, t1, t2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //封装到集合
        page.setList(tradeList);
        return page;
    }
}
