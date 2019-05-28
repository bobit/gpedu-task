package com.demo.juc.thread;

/**
 * 创建线程-实现Runnable接口
 *
 * @author: zhangb
 */
public class RunableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("创建线程：" +
                "runable" +
                "");
    }
    public static void main(String args[]) {
        RunableDemo runableDemo = new RunableDemo();

        Thread thread = new Thread(runableDemo);
        thread.start();
    }
}
