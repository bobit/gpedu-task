package com.demo.designpattern.decorator.display;

/**
 * 装饰边框的抽象类
 *
 * @author zhangb
 */
public abstract class Border extends Display {
    protected Display display;          // 表示被装饰物

    protected Border(Display display) { // 在生成实例时通过参数指定  被装饰物
        this.display = display;
    }
}