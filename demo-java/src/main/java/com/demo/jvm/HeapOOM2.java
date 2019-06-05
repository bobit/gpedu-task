package com.demo.jvm;

/**
 * 大对象直接进入老年代
 * 大对象是指需要大量连续空间的对象如字符串和数组。
 *
 *
 * @author: zhangb
 */
public class HeapOOM2 {
    static class OOMObject {}
    /**
     * 使用 Serial / Serial Old 收集器
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * -XX:PretenureSizeThreshold=3145728(仅Serial、PreNew有效)
     * @param args
     */
    private static final int _1MB = 1024*1024;
    public static void main(String[] args) {
        byte[] b1;
        b1 = new byte[4*_1MB];
    }
}
