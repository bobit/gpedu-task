package com.demo.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程-采用Callable接口-lambda表达式
 *
 * @author: zhangb
 */
public class CallableDemo2 {

    public static void main(String args[]) {

        //先使用Lambda表达式创建Callable<Integer>对象，
        //并使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>) () -> {

            //这里相当于call方法执行体。
            int i = 0;
            for (i = 0; i < 10; i++) {
                //当前线程
                System.out.println("当前线程是：" + Thread.currentThread()
                        + ":" + i);
//                System.out.println(Thread.currentThread().getName() + "=====" + i);
            }
            return i;
        });

        //创建一个线程，并start启动它。
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "=======" + i);
            if (i == 0) {
                Thread t1 = new Thread(task, "我是父线程");
                t1.start();
            }
        }

        //得到返回值，注意这个必须要有显示抛出异常
        try {
            System.out.println("子线程的返回值" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}