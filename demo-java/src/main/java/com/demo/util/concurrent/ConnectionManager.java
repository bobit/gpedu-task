package com.demo.util.concurrent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Controller
 *
 * @Author: zhangb
 * @Date: 2019-04-19 0:51
 */
public class ConnectionManager {
    private static Connection connect = null;

    public static Connection openConnection() throws SQLException {
        if (connect == null) {
            connect = DriverManager.getConnection("url");

        }
        return connect;
    }

    public static void closeConnection() throws SQLException {
        if (connect != null) {
            connect.close();
        }
    }
}
