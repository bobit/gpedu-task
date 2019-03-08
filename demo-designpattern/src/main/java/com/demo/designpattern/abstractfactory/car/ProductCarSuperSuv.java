package com.demo.designpattern.abstractfactory.car;

/**
 * 具体产品角色 高配
 *
 * @Author: zhangb
 * @Date: 2019/3/8 16:54
 */
public class ProductCarSuperSuv implements AbstractProductCarSuv {
    @Override
    public void ignition() {
        System.out.println("高级 suv 点火");
    }

    @Override
    public void startup() {
        System.out.println("高级 suv 启动");
    }

    @Override
    public void autoStart() {
        System.out.println("高级 suv 可以一键启动");
    }
}
