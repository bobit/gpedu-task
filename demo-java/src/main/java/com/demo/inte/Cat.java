package com.demo.inte;

/**
 * 定义类继承抽象类
 *
 * @Author: zhangb
 */
public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println(this.getName() + "爱吃饭");
    }

    ;

    @Override
    public void sleep() {
        System.out.println(this.getName() + "爱睡觉");
    }
}
