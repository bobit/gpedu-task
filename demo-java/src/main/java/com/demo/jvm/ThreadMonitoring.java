package com.demo.jvm;

/**
 * 模拟线程监控demo
 *
 * @author: zhangb
 */
public class ThreadMonitoring {

    // 线程死循环
    //busyThread线程一直执行空循环，从堆栈跟踪上看到一直停留在ThreadMonitoring.java的8行（while (true) {}）处。此时线程为Runnable状态且没有归还线程执行令牌的动作，会在空循环上用尽全部执行时间直到线程切换，消耗较多的CPU资源。
    public static void busyThread() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while (true){

                }
            }
        }, "busyThread");
        thread.start();
    }
    // 线程锁等待
    //lockThread线程等待着lock对象notify或notifyAll方法出现，此线程处于Waiting状态，在被唤醒前不会被分配执行时间。
    public static void lockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        //
                    }
                }
            }
        }, "lockThread");
        thread.start();
    }
    public static void main(String[] args) throws Exception {
        busyThread();
        Object lock = new Object();
        lockThread(lock);
    }
}
