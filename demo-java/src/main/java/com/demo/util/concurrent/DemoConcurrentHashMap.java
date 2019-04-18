package com.demo.util.concurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap测试
 * ConcurrentHashMap是怎么实现线程安全的呢？ConcurrentHashMap的工作机制？
 * PS:肯定不可能是每个方法加synchronized，那样就变成了HashTable。
 * ConcurrentHashMap通过把整个Map分为N个Segment（类似HashTable） ，根据自定的hashcode算法生成的对象来获取对应hashcode的分段块进行加锁，不用整体加锁，可以提供相同的线程安全，但是效率提升N倍，默认提升16倍。
 *
 * @author zhangb
 */
public class DemoConcurrentHashMap {

    private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

    public static void main(String[] args) {
        new Thread("Thread1") {
            @Override
            public void run() {
                map.put(3, 33);
            }
        };

        new Thread("Thread2") {
            @Override
            public void run() {
                map.put(4, 44);
            }
        };

        new Thread("Thread3") {
            @Override
            public void run() {
                map.put(7, 77);
            }
        };
        System.out.println(map);
    }
}

