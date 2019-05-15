package com.demo.core;

/**
 * Description
 *
 * @author: zhangb
 */
public class Person implements Cloneable {
    public Person(int age, String name) {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

}
