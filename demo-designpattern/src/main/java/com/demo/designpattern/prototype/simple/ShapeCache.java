package com.demo.designpattern.prototype.simple;

import java.util.Hashtable;

/**
 * 获取实体类，并把它们存储在一个 Hashtable 中
 *
 * @Author: zhangb
 * @Date: 2019/3/10 16:35
 */
public class ShapeCache {
    private static Hashtable<String, PrototypeShape> shapeMap
            = new Hashtable<String, PrototypeShape>();

    public static PrototypeShape getShape(String shapeId) {
        PrototypeShape cachedPrototypeShape = shapeMap.get(shapeId);
        return (PrototypeShape) cachedPrototypeShape.clone();
    }

    // 创建每种形状,存储在一个 Hashtable 中
    public static void loadCache() {
        ConcretePrototypeCircle concretePrototypeCircle = new ConcretePrototypeCircle();
        concretePrototypeCircle.setId("1");
        shapeMap.put(concretePrototypeCircle.getId(), concretePrototypeCircle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
