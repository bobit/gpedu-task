package com.demo.inte;

/**
 * 定义一个抽象类
 *
 * @Author: zhangb
 */
public abstract class Animal {
    //成员变量
    private String name;
    private int age;

    //空参构造方法
    public Animal() {
    }

    //有参构造方法
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    //抽象方法
    public abstract void eat();

    public abstract void sleep();
}
