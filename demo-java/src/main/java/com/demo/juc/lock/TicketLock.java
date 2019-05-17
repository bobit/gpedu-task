package com.demo.juc.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 保证公平性的spinLock，实现类似银行叫号，服务号=被呼叫号 获得锁
 * ！= 则自旋
 * 票号
 * 排位号
 * 服务号
 *
 * @author:zhangb
 */

public class TicketLock implements Lock {
    private AtomicInteger serviceNum = new AtomicInteger(1);

    private AtomicInteger ticketNum = new AtomicInteger(0);

    private final static ThreadLocal<Integer> ownNum = new ThreadLocal<>();

    @Override
    public void lock() {
        //获取自己的排队号
        int ownCalledNum = ticketNum.incrementAndGet();
        //保存在当前线程里
        ownNum.set(ownCalledNum);
        //排队号不等于服务号  自旋
        while (ownCalledNum != serviceNum.get()) {

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
    public Condition newCondition() {
        return null;
    }

    @Override
    public void unlock() {
        //服务号=自己的排队号才能释放锁
        //保证只有获得锁的线程才能释放锁
        serviceNum.compareAndSet(ownNum.get(), serviceNum.get() + 1);
    }
}