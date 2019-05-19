package com.demo.juc.synchronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock是Lock接口的一个实现类。
 * 演示Lock接口的方法，以ReentrantLock作为示例说明。
 * 该demo模拟售票情况,tickets总票数。开启了10个窗口售票，售完为止
 *
 * @author: zhangb
 */
public class ReentrantLockDemo implements Runnable {

    private Lock lock = new ReentrantLock();

    private int tickets = 200;

    @Override
    public void run() {
        while (true) {
            lock.lock(); // 获取锁
            try {
                if (tickets > 0) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " " + tickets--);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // 释放所
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(reentrantLockDemo, "thread" + i);
            thread.start();
        }
    }
}