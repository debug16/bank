package com.bank.model;

/**
 * @author Debug16
 * @version 1.0
 * @description: 账户信息
 * @date 2021/12/15 下午 9:44
 */
public class Account {
    private String accountId;   //账户id
    private String password;    //密码
    private double remaining;   //余额

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", password='" + password + '\'' +
                ", remaining=" + remaining +
                '}';
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public Account() {
    }

    public Account(String accountId, String password, double remaining) {
        this.accountId = accountId;
        this.password = password;
        this.remaining = remaining;
    }
}
