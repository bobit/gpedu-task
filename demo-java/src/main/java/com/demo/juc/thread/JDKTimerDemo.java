package com.demo.juc.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Description
 *
 * @author: zhangb
 */
public class JDKTimerDemo {
    public static void main(String args[]) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "is running");
            }
        }, new Date(), 6000);
    }
}
