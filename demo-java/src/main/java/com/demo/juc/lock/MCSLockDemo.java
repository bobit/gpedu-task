package com.demo.juc.lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Description
 *
 * @author: zhangb
 */
public class MCSLockDemo {
    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean isWaiting = true; // 默认是在等待锁
    }

    volatile MCSNode queue;// 指向最后一个申请锁的MCSNode
    private static final AtomicReferenceFieldUpdater<MCSLockDemo, MCSNode> UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(MCSLockDemo.class, MCSNode.class, "queue");

    public void lock(MCSNode currentThread) {
        MCSNode predecessor = UPDATER.getAndSet(this, currentThread);// step 1
        if (predecessor != null) {
            predecessor.next = currentThread;// step 2
            while (currentThread.isWaiting) {// step 3
            }
        } else { // 只有一个线程在使用锁，没有前驱来通知它，所以得自己标记自己已获得锁
            currentThread.isWaiting = false;
        }
    }

    public void unlock(MCSNode currentThread) {
        if (currentThread.isWaiting) {// 锁拥有者进行释放锁才有意义
            return;
        }

        if (currentThread.next == null) {// 检查是否有人排在自己后面
            if (UPDATER.compareAndSet(this, currentThread, null)) {// step 4
                // compareAndSet返回true表示确实没有人排在自己后面
                return;
            } else {
                // 突然有人排在自己后面了，可能还不知道是谁，下面是等待后续者
                // 这里之所以要忙等是因为：step 1执行完后，step 2可能还没执行完
                while (currentThread.next == null) { // step 5
                }
            }
        }
        currentThread.next.isWaiting = false;
        currentThread.next = null;// for GC
    }
}