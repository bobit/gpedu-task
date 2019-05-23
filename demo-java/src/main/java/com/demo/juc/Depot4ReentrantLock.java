package com.demo.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description
 *
 * @author: zhangb
 */
public class Depot4ReentrantLock {
    private int mCapacity;
    private int mSize;
    private Lock mLock;
    private Condition mFullCondition;
    private Condition mEmptyCondition;

    public Depot4ReentrantLock(int capacity) {
        mCapacity = capacity;
        mSize = 0;
        mLock = new ReentrantLock();
        mFullCondition = mLock.newCondition();
        mEmptyCondition = mLock.newCondition();
    }


    public void produce(int val) {
        mLock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (mSize >= mCapacity) {
                    mFullCondition.await();
                }

                int inc = (mSize + left) > mCapacity ? (mCapacity - mSize) : left;
                mSize += inc;
                left -= inc;

                System.out.println("produce  Thread: " + Thread.currentThread().getName() + " mSize: " + mSize + " left: " + left);

                mEmptyCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }

    public void consume(int val) {
        mLock.lock();

        try {
            int left = val;
            while (left > 0) {
                while (mSize <= 0) {
                    mEmptyCondition.await();
                }
                int inc = (mSize - left) < 0 ? mSize : left;
                mSize -= inc;
                left -= inc;
                System.out.println("consume  Thread: " + Thread.currentThread().getName() + " mSize: " + mSize + " left: " + left);
                mFullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mLock.unlock();
        }
    }
}

class Producer1 {
    private Depot4ReentrantLock depot;

    public Producer1(Depot4ReentrantLock depot) {
        this.depot = depot;
    }

    public void produce(int val) {
        new Thread() {
            @Override
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}

class Customer1 {
    private Depot4ReentrantLock depot;

    public Customer1(Depot4ReentrantLock depot) {
        this.depot = depot;
    }

    public void consume(int val) {
        new Thread() {
            @Override
            public void run() {
                depot.consume(val);
            }
        }.start();
    }


    public static void main(String[] args) {
        Depot4ReentrantLock depot = new Depot4ReentrantLock(100);
        Producer1 producer = new Producer1(depot);
        Customer1 customer = new Customer1(depot);

        producer.produce(60);
        producer.produce(120);
        customer.consume(90);
        customer.consume(150);
        producer.produce(110);
    }
}
