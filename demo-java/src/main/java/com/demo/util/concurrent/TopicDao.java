package com.demo.util.concurrent;

import java.sql.Connection;
import java.sql.Statement;

/**
 * 非线程安全
 *
 * @Author: zhangb
 */
public class TopicDao {

    private Connection conn;//①一个非线程安全的变量

    public void addTopic() {
        //Statement stat = conn.createStatement();//②引用非线程安全变量
    }
}

//由于①处的conn是成员变量，因为addTopic()方法是非线程安全的，必须在使用时创建一个新TopicDao实例（非singleton）。下面使用ThreadLocal对conn这个非线程安全的“状态”进行改造：
