package com.bank.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Debug16
 * @version 1.0
 * @description: 日期类工具
 * @date 2021/12/17 下午 11:03
 */
public class DateUtils {

    /**
     * 把时间转换成 yyyy-MM-dd hh:mm:ss格式的字符串
     *
     * @param date 时间对象
     * @return String
     */
    public static String getDateStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
    }

    /**
     * 把当前时间转换成 yyyy-MM-dd hh:mm:ss格式的字符串
     *
     * @return String
     */
    public static String getNewDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date());
    }
}
