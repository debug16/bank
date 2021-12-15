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
    private int tradeType; //交易类型 '1存款 2取款 3取出'
    private double tradeMoney;  //交易金额
    private Date tradeTime; //交易时间
    private String tradeDigest; //交易摘要

}
