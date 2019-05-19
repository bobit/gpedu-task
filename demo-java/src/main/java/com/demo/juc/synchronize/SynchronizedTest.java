package com.demo.juc.synchronize;

/**
 * Description
 *
 * @author: zhangb
 */
public class SynchronizedTest {
    public synchronized void doSomething() {
        //采用实例对象作为锁对象
    }
    public static synchronized void doSomething2() {
        //采用SynchronizedTest.class 实例作为锁对象
    }

}
