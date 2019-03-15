package com.demo.designpattern.prototype.simple;

/**
 * 创建扩展了抽象类的实体类。
 *
 * @Author: zhangb
 * @Date: 2019/3/10 16:34
 */
public class Rectangle extends PrototypeShape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
