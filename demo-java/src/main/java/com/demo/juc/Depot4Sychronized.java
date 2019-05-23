package com.demo.juc;

/**
 * Description
 *
 * @author: zhangb
 */
public class Depot4Sychronized {
    private int mCapacity;
    private int mSize;

    public Depot4Sychronized(int capacity) {

        mCapacity = capacity;
        mSize = 0;
    }


    public synchronized void produce(int val) {
        try {
            int left = val;
            while (left > 0) {
                while (mSize >= mCapacity) {
                    wait();
                }

                int inc = (mSize + left) > mCapacity ? (mCapacity - mSize) : left;
                mSize += inc;
                left -= inc;

                System.out.println("produce  Thread: " + Thread.currentThread().getName() + " val: " + val + " mSize: " + mSize + " left: " + left);

                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume(int val) {
        try {
            int left = val;
            while (left > 0) {
                while (mSize <= 0) {
                    wait();
                }
                int inc = (mSize - left) < 0 ? mSize : left;
                mSize -= inc;
                left -= inc;
                System.out.println("consume  Thread: " + Thread.currentThread().getName() + " val: " + val + " mSize: " + mSize + " left: " + left);
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer {
    private Depot4Sychronized depot;

    public Producer(Depot4Sychronized depot) {
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


class Customer {
    private Depot4Sychronized depot;

    public Customer(Depot4Sychronized depot) {
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
        Depot4Sychronized depot = new Depot4Sychronized(100);
        Producer producer = new Producer(depot);
        Customer customer = new Customer(depot);

        producer.produce(60);
        producer.produce(120);
        customer.consume(90);
        customer.consume(150);
        producer.produce(110);
    }
}
