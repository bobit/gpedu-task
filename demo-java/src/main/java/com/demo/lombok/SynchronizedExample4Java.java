package com.demo.lombok;

/**
 * Controller
 *
 * @Author: zhangb
 * @Date: 2017/12/19 23:37
 */
public class SynchronizedExample4Java {
    private static final Object $LOCK = new Object[0];
    private final Object $lock = new Object[0];
    private final Object readLock = new Object();

    public static void hello() {
        synchronized ($LOCK) {
            System.out.println("world");
        }
    }

    public int answerToLife() {
        synchronized ($lock) {
            return 42;
        }
    }

    public void foo() {
        synchronized (readLock) {
            System.out.println("bar");
        }
    }
}