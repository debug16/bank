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
    private final Conn conn = new Conn();
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

    /**
     * 获取指定页的交易信息通过账户
     *
     * @param offset    偏移量
     * @param pageSize  页数量
     * @param accountId 账户
     * @return List<Trade>
     * @throws SQLException
     */
    public List<Trade> selectPageByAccountId(int offset, int pageSize, String accountId) throws SQLException {
        String sql = "SELECT * FROM `bank`.`trade` WHERE `AccountID` = ? ORDER BY trade.ID DESC LIMIT ?,?";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, accountId);
        ps.setInt(2, offset);
        ps.setInt(3, pageSize);
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

    /**
     * 获取指定时间内的交易信息
     *
     * @param offset    偏移量
     * @param pageSize  获取的数量
     * @param accountId 账户
     * @param time1     开始时间
     * @param time2     结束时间
     * @return List<Trade>
     * @throws SQLException
     */
    public List<Trade> getBetweenTime(int offset, int pageSize, String accountId, String time1, String time2) throws SQLException {
        String sql = "SELECT trade.* FROM trade WHERE trade.TradeTime BETWEEN ? AND ? AND trade.AccountID = ? ORDER BY trade.ID DESC LIMIT ?,?";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, time1);
        ps.setString(2, time2);
        ps.setString(3, accountId);
        ps.setInt(4, offset);
        ps.setInt(5, pageSize);
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

    /**
     * 获取账户的交易记录总数
     *
     * @param accountId 账户名
     * @return int 数量
     * @throws SQLException
     */
    public int getCountByAccountId(String accountId) throws SQLException {
        int goodsCount = 0;
        String sql = "select count(*) acc from `trade` where `AccountID`= ?";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, accountId);
        rs = ps.executeQuery();
        rs.next();
        goodsCount = rs.getInt("acc");
        Conn.ClossAll(cn, ps, rs);
        return goodsCount;
    }

    /**
     * 获取指定时间内的交易总数
     *
     * @param accountId 账户
     * @param t1        开始时间
     * @param t2        结束时间
     * @return int 数量
     * @throws SQLException
     */
    public int getCountByTime(String accountId, String t1, String t2) throws SQLException {
        int goodsCount = 0;
        String sql = "select count(*) acc from `trade` where `AccountID`= ? And trade.TradeTime BETWEEN ? AND ?";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, accountId);
        ps.setString(2, t1);
        ps.setString(3, t2);
        rs = ps.executeQuery();
        rs.next();
        goodsCount = rs.getInt("acc");
        Conn.ClossAll(cn, ps, rs);
        return goodsCount;
    }
}
