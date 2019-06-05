package com.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟内存监控demo
 * -Xms100M -Xmx100M -XX:+UseSerialGC
 * “内存”页签相当于可视化的 jstat 命令，用于监视受收集器管理的虚拟机内存（Java堆和永久代）的变化趋势。　　
 * @author: zhangb
 */
public class OOMObject {
    // 内存占用，每一个OOMObject对象大约占用64K
    public byte[] placeholder = new byte[64 * 1024];
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            // 稍作延迟让内存变化曲线更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        fillHeap(800);
    }
}
