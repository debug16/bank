package com.bank.model;

import java.util.Date;

/**
 * @author Debug16
 * @version 1.0
 * @description: 交易信息类
 * @date 2021/12/15 下午 9:47
 */
public class Trade {

    private long id; //流水号
    private String accountId;   //账户id
    private int tradeType; //交易类型 '1存款 2取款 3转账'
    private double tradeMoney;  //交易金额
    private Date tradeTime; //交易时间
    private String tradeDigest; //交易摘要

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", tradeType=" + tradeType +
                ", tradeMoney=" + tradeMoney +
                ", tradeTime=" + tradeTime +
                ", tradeDigest='" + tradeDigest + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }

    public double getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(double tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTradeDigest() {
        return tradeDigest;
    }

    public void setTradeDigest(String tradeDigest) {
        this.tradeDigest = tradeDigest;
    }

    public Trade() {
    }

    public Trade(String accountId, int tradeType, double tradeMoney, Date tradeTime, String tradeDigest) {
        this.accountId = accountId;
        this.tradeType = tradeType;
        this.tradeMoney = tradeMoney;
        this.tradeTime = tradeTime;
        this.tradeDigest = tradeDigest;
    }

    public Trade(long id, String accountId, int tradeType, double tradeMoney, Date tradeTime, String tradeDigest) {
        this.id = id;
        this.accountId = accountId;
        this.tradeType = tradeType;
        this.tradeMoney = tradeMoney;
        this.tradeTime = tradeTime;
        this.tradeDigest = tradeDigest;
    }
}
