package com.demo.juc.synchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 从输出结果可以看出，thread01正常结束程序，thread02被中断程序，执行catch中的代码块
 *
 * @author: zhangb
 */
public class ReentrantLockDemo2 implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + " running");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " finished");
            lock.unlock();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo2 reentrantLockDemo = new ReentrantLockDemo2();
        Thread thread01 = new Thread(reentrantLockDemo, "thread01");
        Thread thread02 = new Thread(reentrantLockDemo, "thread02");
        thread01.start();
        thread02.start();
        thread02.interrupt();
    }
}