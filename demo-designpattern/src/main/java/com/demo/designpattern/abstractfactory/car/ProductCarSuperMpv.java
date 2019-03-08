package com.demo.designpattern.abstractfactory.car;

/**
 * 具体产品角色 高配
 *
 * @Author: zhangb
 * @Date: 2019/3/8 16:55
 */
public class ProductCarSuperMpv implements AbstractProductCarMpv {

    @Override
    public void ignition() {
        System.out.println("高级 mpv 点火");
    }

    @Override
    public void startup() {
        System.out.println("高级 mpv 启动");
    }
}
