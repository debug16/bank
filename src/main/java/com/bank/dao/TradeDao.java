package com.bank.dao;

import com.bank.model.Trade;
import com.bank.utils.Conn;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Debug16
 * @version 1.0
 * @description: 交易信息操作类
 * @date 2021/12/16 下午 3:12
 */
public class TradeDao {
    private Conn conn = new Conn();
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * 添加交易记录
     *
     * @param cn    数据库连接
     * @param trade 交易信息对象
     * @return boolean
     * @throws SQLException
     */
    public boolean addTrade(Connection cn, Trade trade) throws SQLException {
        String sql = "INSERT INTO `bank`.`trade` (`AccountID`, `TradeType`, `TradeMoney`, `TradeTime`, `TradeDigest`) VALUES (?, ?, ?, ?, ?)";
        ps = cn.prepareStatement(sql);
        ps.setString(1, trade.getAccountId());
        ps.setInt(2, trade.getTradeType());
        ps.setDouble(3, trade.getTradeMoney());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Sdata = simpleDateFormat.format(trade.getTradeTime());

        ps.setString(4, Sdata);
        ps.setString(5, trade.getTradeDigest());
        boolean i = ps.executeUpdate() > 0;
        Conn.ClossAll(null, ps, null);
        return i;
    }

    public List<Trade> getAllTradeByAccountId(String accountId) throws SQLException {
        String sql = "SELECT * FROM `bank`.`trade` WHERE `AccountID` = ? ORDER BY trade.ID DESC";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, accountId);
        rs = ps.executeQuery();
        List<Trade> tradeList = new ArrayList<>();
        while (rs.next()) {
            Trade trade = new Trade();
            trade.setId(rs.getLong("ID"));
            trade.setTradeType(rs.getInt("TradeType"));
            trade.setTradeMoney(rs.getDouble("TradeMoney"));
            trade.setTradeTime(rs.getTimestamp("TradeTime"));
            trade.setTradeDigest(rs.getString("TradeDigest"));
            tradeList.add(trade);
        }
        Conn.ClossAll(cn, ps, rs);
        return tradeList;
    }

    public List<Trade> getBetweenTime(String accountId, String time1, String time2) throws SQLException {
        String sql = "SELECT trade.* FROM trade WHERE trade.TradeTime BETWEEN ? AND ? AND trade.AccountID = ?";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, time1);
        ps.setString(2, time2);
        ps.setString(3, accountId);
        rs = ps.executeQuery();
        List<Trade> tradeList = new ArrayList<>();
        while (rs.next()) {
            Trade trade = new Trade();
            trade.setId(rs.getLong("ID"));
            trade.setTradeType(rs.getInt("TradeType"));
            trade.setTradeMoney(rs.getDouble("TradeMoney"));
            trade.setTradeTime(rs.getTimestamp("TradeTime"));
            trade.setTradeDigest(rs.getString("TradeDigest"));
            tradeList.add(trade);
        }
        Conn.ClossAll(cn, ps, rs);
        return tradeList;
    }
}
