package com.bank.utils;

import java.sql.*;

/**
 * @author Debug16
 * @version 1.0
 * @description: 数据库连接类
 * @date 2021/12/16 下午 2:15
 */
public class Conn {
    private Connection conn = null;

    public Connection getConn() throws SQLException {
        //判断连接是否关闭 或者连接是否为空
        if (this.conn != null && !this.conn.isClosed()) return this.conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bank?useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf-8&allowPublicKeyRetrieval=true";
            this.conn = DriverManager.getConnection(url, "root", "1620014532");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        return this.conn;
    }
    public static void ClossAll(Connection conn, Statement stmt, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
