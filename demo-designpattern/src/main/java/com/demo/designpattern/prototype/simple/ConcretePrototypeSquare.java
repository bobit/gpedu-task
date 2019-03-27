package com.demo.designpattern.prototype.simple;

/**
 * 创建扩展了抽象类的实体类。
 *
 * @Author: zhangb
 * @Date: 2019/3/10 16:35
 */
public class ConcretePrototypeSquare extends PrototypeShape {

    public ConcretePrototypeSquare() {
        type = "ConcretePrototypeSquare";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}