package com.demo.jvm;

/**
 * 长期存活的对象进入老年代
 *
 * 　设置-XX:MaxTenuringThreshold参数设置对象进入老年代的年龄阈值。对象在Eden区中经过一次GC的对象年龄增加1，对象成功转移到Survivor中每熬过“”一次GC，年龄就增加1。　
 *
 * @author: zhangb
 */
public class HeapOOM3 {

    /**

     * 使用 Serial / Serial Old 收集器
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     * @param args
     */
    private static final int _1MB = 1024*1024;
    public static void main(String[] args) {
        byte[] b1, b2, b3, b4;
        b1 = new byte[_1MB/4];
        b2 = new byte[2*_1MB];
        b3 = new byte[6*_1MB];
        b3 = null;
        b4 = new byte[4*_1MB];
    }

}
