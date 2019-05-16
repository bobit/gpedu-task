package com.demo.designpattern.singleton;

/**
 * 单例模式（Singleton Pattern）
 * 单例模式中的懒汉模式
 * 线程不安全实例
 *
 * @Author: zhangb
 * @Date: 2019/3/9 16:55
 */
public class SingletonNotSafe {
    // 声明变量
    private static SingletonNotSafe singleton = null;

    // 私有构造函数
    // 限制产生多个对象
    private SingletonNotSafe() {
    }

    // 提供对外方法，通过该方法获得实例对象
    public static SingletonNotSafe getInstanceOnNotSafe() {
        if (singleton == null) {
            singleton = new SingletonNotSafe();
        }
        return singleton;
    }

    // 提供对外方法，通过该方法获得实例对象
    public static SingletonNotSafe getInstance() {
        if (singleton == null) {
            synchronized (SingletonNotSafe.class) {
                if (singleton == null) {
                    singleton = new SingletonNotSafe();
                }
            }
        }
        return singleton;
    }


}
