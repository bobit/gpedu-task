package com.demo.designpattern.prototype.simple;

/**
 * 创建扩展了抽象类的实体类。
 *
 * @Author: zhangb
 * @Date: 2019/3/10 16:35
 */
public class Square extends PrototypeShape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}