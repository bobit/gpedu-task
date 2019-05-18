package com.demo.juc.lock;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * CLH 锁与 MCS 锁的原理大致相同，都是各个线程轮询各自关注的变量，来避免多个线程对同一个变量的轮询，从而从 CPU 缓存一致性的角度上减少了系统的消耗。
 * CLH 锁与 MCS 锁最大的不同是，MCS 轮询的是当前队列节点的变量，而 CLH 轮询的是当前节点的前驱节点的变量，来判断前一个线程是否释放了锁。
 *
 * @author: zhangb
 */
public class CLHLockDemo {
    public static class CLHNode {
        private volatile boolean isWaiting = true; // 默认是在等待锁
    }

    private volatile CLHNode tail;
    private static final AtomicReferenceFieldUpdater<CLHLockDemo, CLHNode> UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(CLHLockDemo.class, CLHNode.class, "tail");

    public void lock(CLHNode currentThread) {
        CLHNode preNode = UPDATER.getAndSet(this, currentThread);
        if (preNode != null) {//已有线程占用了锁，进入自旋
            while (preNode.isWaiting) {
            }
        }
    }

    public void unlock(CLHNode currentThread) {
        // 如果队列里只有当前线程，则释放对当前线程的引用（for GC）。
        if (!UPDATER.compareAndSet(this, currentThread, null)) {
            // 还有后续线程
            currentThread.isWaiting = false;// 改变状态，让后续线程结束自旋
        }
    }
}