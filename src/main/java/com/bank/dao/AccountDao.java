package com.bank.dao;

import com.bank.model.Account;
import com.bank.utils.Conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Debug16
 * @version 1.0
 * @description: 账户操作类
 * @date 2021/12/16 下午 2:17
 */
public class AccountDao {
    private final Conn conn = new Conn();
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * 用户登录验证
     *
     * @param accountId 账号
     * @param password  密码
     * @return Account || null
     * @throws SQLException
     */
    public Account login(String accountId, String password) throws SQLException {
        String sql = "SELECT * FROM `bank`.`account` WHERE `AccountID` = ? AND `Password` = ?";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, accountId);
        ps.setString(2, password);
        rs = ps.executeQuery();
        Account account = null;
        if (rs.next()) {
            account = new Account();
            account.setAccountId(rs.getString("AccountID"));
            account.setPassword(rs.getString("Password"));
            account.setRemaining(rs.getLong("Remaining"));
        }
        Conn.ClossAll(cn, ps, rs);
        return account;
    }

    /**
     * 查找是否有该账号
     *
     * @param account 账号
     * @return boolean
     */
    public boolean hasAccount(String account) throws SQLException {
        String sql = "select * from `Account` where AccountID = ?";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, account);
        rs = ps.executeQuery();
        boolean flag = rs.next();
        Conn.ClossAll(cn, ps, rs);
        return flag;
    }

    /**
     * 获取账号的余额
     *
     * @param account 账号
     * @return double 金额
     * @throws SQLException
     */
    public double getMoney(String account) throws SQLException {
        String sql = "select `Remaining` from `Account` where AccountID = ?";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, account);
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getDouble("Remaining");
        }
        Conn.ClossAll(cn, ps, rs);
        return 0;
    }

    /**
     * 获取账号详情
     *
     * @param accountId 账号
     * @return Account || null
     * @throws SQLException
     */
    public Account getAccountDetails(String accountId) throws SQLException {
        String sql = "SELECT * FROM `bank`.`account` WHERE `AccountID` = ?";
        cn = conn.getConn();
        ps = cn.prepareStatement(sql);
        ps.setString(1, accountId);
        rs = ps.executeQuery();
        Account account = null;
        if (rs.next()) {
            account = new Account();
            account.setAccountId(rs.getString("AccountID"));
            account.setPassword(rs.getString("Password"));
            account.setRemaining(rs.getLong("Remaining"));
        }
        Conn.ClossAll(cn, ps, rs);
        return account;
    }

    /**
     * 余额增加
     *
     * @param cn        数据库连接
     * @param accountId 账号
     * @param money     金额
     * @return boolean
     * @throws SQLException
     */
    public boolean addMoney(Connection cn, String accountId, double money) throws SQLException {
        String sql = "UPDATE `bank`.`account` SET `Remaining` = (Remaining + ?) WHERE `AccountID` = ?";
        ps = cn.prepareStatement(sql);
        ps.setDouble(1, money);
        ps.setString(2, accountId);
        boolean i = ps.executeUpdate() > 0;
        Conn.ClossAll(null, ps, null);
        return i;
    }

    /**
     * 余额减少
     *
     * @param cn        数据库连接
     * @param accountId 账号
     * @param money     金额
     * @return boolean
     * @throws SQLException
     */
    public boolean subMoney(Connection cn, String accountId, double money) throws SQLException {
        String sql = "UPDATE `bank`.`account` SET `Remaining` = (Remaining - ?) WHERE `AccountID` = ?";
        ps = cn.prepareStatement(sql);
        ps.setDouble(1, money);
        ps.setString(2, accountId);
        boolean i = ps.executeUpdate() > 0;
        Conn.ClossAll(null, ps, null);
        return i;
    }

}
