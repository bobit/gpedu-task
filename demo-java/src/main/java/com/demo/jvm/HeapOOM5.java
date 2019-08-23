package com.demo.jvm;

/**
 *
 * -Xmx10m -Xms10m -XX:+PrintGCDetails
 *
 * @author: zhangb
 */
public class HeapOOM5 {
    public static void main(String args[]) {
        // todo
        String str = "showGCStrategy";
        while (true) {
            str += str + str;
            str.intern();//强制产生垃圾
        }
    }
}
