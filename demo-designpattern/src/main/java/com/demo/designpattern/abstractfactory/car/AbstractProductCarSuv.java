package com.demo.designpattern.abstractfactory.car;

/**
 * 抽象产品角色 suv
 *
 * @Author: zhangb
 * @Date: 2019/3/8 16:53
 */
public interface AbstractProductCarSuv {
    // 点火
    void ignition();

    // 启动
    void startup();

    // 一键启动
    void autoStart();
}
