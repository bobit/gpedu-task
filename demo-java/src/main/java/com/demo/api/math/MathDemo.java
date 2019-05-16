package com.demo.api.math;

/**
 * Description
 *
 * @author: zhangb
 */
public class MathDemo {
    public static void main(String args[]) {
        //四舍五入的原理是在参数上加 0.5 然后进行取整。
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
    }
}
