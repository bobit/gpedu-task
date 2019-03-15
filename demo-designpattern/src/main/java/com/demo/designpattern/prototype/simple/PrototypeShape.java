package com.demo.designpattern.prototype.simple;

/**
 * 创建一个实现了 Clonable 接口的抽象类。
 *
 * @Author: zhangb
 * @Date: 2019/3/10 16:32
 */
public abstract class PrototypeShape implements Cloneable {
    private String id;
    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}
