package com.demo.designpattern.abstractfactory.car;

/**
 * 抽象工厂角色
 *
 * @Author: zhangb
 * @Date: 2019/3/8 16:53
 */
public interface AbstractFactory {
    AbstractProductCarMpv createAbstractProductCarMpv();

    AbstractProductCarSuv createAbstractProductCarSuv();

}
