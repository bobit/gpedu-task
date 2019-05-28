package com.demo.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程-采用Callable接口-普通创建callable实现实现类的方式
 *
 * @author: zhangb
 */
public class CallableDemo implements Callable {

    //重写执行体call()
    @Override
    public Integer call() throws Exception {

        int i = 0;
        for (; i < 10; i++) {
            //当前线程
            System.out.println("当前线程是：" + Thread.currentThread()
                    + ":" + i);
        }
        return i;
    }

    public static void main(String[] args) {

        //创建callable对象
        CallableDemo call = new CallableDemo();
        FutureTask<Integer> task = new FutureTask<Integer>(call);
        Thread th = new Thread(task, "我是父线程");

        for (int i = 0; i < 3; i++) {
            //当前线程
            System.out.println(Thread.currentThread().getName() + "当前线程");
            if (i == 0) {
                th.start();
            }
        }

        //得到返回值
        try {
            System.out.println("子线程的返回值是:" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
