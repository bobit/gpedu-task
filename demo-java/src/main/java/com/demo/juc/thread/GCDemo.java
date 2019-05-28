package com.demo.juc.thread;

import java.util.ArrayList;

/**
 * Description
 *
 * @author: zhangb
 */
public class GCDemo {
    public static void main(String args[]) {
        byte[] array = new byte[1024 * 64];
        ArrayList<byte[]> list = new ArrayList<byte[]>();
        new Thread(new MyThread()).start();
        while (true) {
            list.add(array);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        testStack();
    }

    public void testStack() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        testStack();
    }
}


