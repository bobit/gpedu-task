package com.demo.core;

/**
 * Description
 *
 * @author: zhangb
 */
public class CloneDemo {
    public static void main(String args[]) throws CloneNotSupportedException {
        // 复制对象和复制引用的区别
        Person p = new Person(35, "zhang");
        Person p1 = p;
        Person p2 = (Person) p.clone();
        System.out.println(p);
        System.out.println(p1);
        System.out.println(p2);
    }
}
