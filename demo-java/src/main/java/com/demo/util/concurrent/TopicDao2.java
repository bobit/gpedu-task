package com.demo.util.concurrent;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 线程安全
 *
 * @Author: zhangb
 */
public class TopicDao2 {

//①使用ThreadLocal保存Connection变量

    private static ThreadLocal<Connection> connThreadLocal = new ThreadLocal<Connection>();

    public static Connection getConnection() throws SQLException {

//②如果connThreadLocal没有本线程对应的Connection创建一个新的Connection，并将其保存到线程本地变量中。

        if (connThreadLocal.get() == null) {

            Connection conn = ConnectionManager.openConnection();
            connThreadLocal.set(conn);
            return conn;

        } else {
            return connThreadLocal.get();//③直接返回线程本地变量
        }
    }

    public void addTopic() throws SQLException {

//④从ThreadLocal中获取线程对应的Connection

        Statement stat = getConnection().createStatement();
    }
}
