package com.bank.service;

import com.bank.dao.TradeDao;
import com.bank.model.Trade;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public List<Trade> getAllTradeByAccountId(String accountId) {

        List<Trade> tradeList = null;
        try {
            tradeList = td.getAllTradeByAccountId(accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tradeList;
    }

    public List<Trade> getBetweenTime(String accountId, String t1, String t2) {

        List<Trade> tradeList = null;
        try {
            tradeList = td.getBetweenTime(accountId, t1, t2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tradeList;
    }
}
