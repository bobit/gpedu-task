package com.demo.jvm;

/**
 *  内存分配规则
 *  对象优先在Eden分配
 *  大多数情况下，对象会在新生代Eden区中分配，当Eden区中没有足够空间时，虚拟机将发起一次Minor GC。
 *
 * @author: zhangb
 */
public class HeapOOM1 {
    static class OOMObject {}
    /**
     * 使用 Serial / Serial Old 组合收集器
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * @param args
     */
    private static final int _1MB = 1024*1024;
    public static void main(String[] args) {
        byte[] b1, b2, b3, b4;
        b1 = new byte[2*_1MB];
        b2 = new byte[2*_1MB];
        b3 = new byte[2*_1MB];
        b4 = new byte[4*_1MB]; // 此处会出现一次Minor GC
    }
}
