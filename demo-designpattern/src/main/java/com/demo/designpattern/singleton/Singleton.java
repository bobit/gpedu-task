package com.demo.designpattern.singleton;

/**
 * 单例模式（Singleton Pattern）
 * 单例模式中的饿汉模式
 * 通用代码,线程安全实例
 *
 * @Author: zhangb
 * @Date: 2019/3/9 16:53
 */
public class Singleton {
    // 直接创建对象
    private static final Singleton singleton = new Singleton();

    //限制产生多个对象
    private Singleton() {
    }

    //通过该方法获得实例对象
    public static Singleton getSingleton() {
        return singleton;
    }

    //类中其他方法，尽量是static
    public static void doSomething() {
    }
}
