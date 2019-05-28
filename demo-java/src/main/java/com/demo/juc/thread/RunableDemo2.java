package com.demo.juc.thread;

/**
 * 创建线程-实现Runnable接口
 *
 * @author: zhangb
 */
public class RunableDemo2 {
    public static void main(String args[]) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("创建线程：" +
                        "runable" +
                        "");
            }
        };

        new Thread(task).start();
    }
}
