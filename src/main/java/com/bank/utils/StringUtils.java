package com.bank.utils;

/**
 * @author Debug16
 * @version 1.0
 * @description: 字符串工具类
 * @date 2021/12/16 下午 2:34
 */
public class StringUtils {
    public static boolean isNotEmpty(String str) {
        return (str != null && !"".equals(str));
    }
}
