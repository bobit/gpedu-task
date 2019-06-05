package com.demo.jvm;

/**
 * 动态对象年龄判断
 *
 * 　　虚拟机并不是永远的要求对象年龄必须达到MaxTenuringThreshold年龄阈值才能进入老年代，如果Survivor空间中相同年龄所有对象的大小总和大于Survivor空间的一半时，年龄大于或等于该年龄的对象将进入老年代。
 *
 * @author: zhangb
 */
public class HeapOOM4 {

    /**
 * 使用 Serial / Serial Old 收集器
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
 * -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
 * @param args
 */
private static final int _1MB = 1024*1024;
    public static void main(String[] args) {
        byte[] b1, b2, b3, b4;
        b1 = new byte[_1MB/4];
        b2 = new byte[_1MB/4];
        b3 = new byte[4*_1MB];
        b4 = new byte[4*_1MB];
        b4 = null;
        b4 = new byte[4*_1MB];
    }
}