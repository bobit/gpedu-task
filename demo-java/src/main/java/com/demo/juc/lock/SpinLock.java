package com.demo.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Description
 *
 * @author: zhangb
 */
public class SpinLock implements Lock {

    /**
     * currentHoldLockThread == null,无线程占用锁
     */
    private AtomicReference<Thread> currentHoldLockThread =
            new AtomicReference<>();


    @Override
    public void lock() {
        Thread thread = Thread.currentThread();
        /**
         * CAS 更新,当前值不是null 说明锁被占用,自旋
         */
        while (currentHoldLockThread.compareAndSet(null, thread)) {

        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        Thread current = Thread.currentThread();
        //只有持有锁的线程才能释放锁
        if (currentHoldLockThread.get() == Thread.currentThread()) {
            currentHoldLockThread.compareAndSet(current, null);
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
