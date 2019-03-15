package com.demo.designpattern.prototype.simple;

/**
 *  使用 ShapeCache 类来获取存储在 Hashtable 中的形状的克隆。
 *
 * @Author: zhangb
 * @Date: 2019/3/10 16:37
 */
public class ShapeTest {

    public static void main(String[] args) {
        ShapeCache.loadCache();

        PrototypeShape clonedPrototypeShape = (PrototypeShape) ShapeCache.getShape("1");
        System.out.println("PrototypeShape : " + clonedPrototypeShape.getType());

        PrototypeShape clonedPrototypeShape2 = (PrototypeShape) ShapeCache.getShape("2");
        System.out.println("PrototypeShape : " + clonedPrototypeShape.getType());

        PrototypeShape clonedPrototypeShape3 = (PrototypeShape) ShapeCache.getShape("3");
        System.out.println("PrototypeShape : " + clonedPrototypeShape3.getType());
    }
}