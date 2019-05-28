package com.demo.juc.thread;

/**
 * 创建线程-继承Thread类
 *
 * @author: zhangb
 */
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("run");
    }
    public static void main(String args[]) {
        new ThreadDemo().start();
    }

}
