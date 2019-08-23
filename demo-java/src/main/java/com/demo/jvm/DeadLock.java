package com.demo.jvm;

/**
 * 监控线程是否发生死锁demo
 *
 * @author: zhangb
 */
public class DeadLock implements Runnable {
    int a, b;
    public DeadLock (int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new DeadLock(1, 2)).start();
            new Thread(new DeadLock(2, 1)).start();
        }
    }
}