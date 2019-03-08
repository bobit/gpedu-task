package com.demo.designpattern.abstractfactory.car;

/**
 * 具体工厂角色 中配
 *
 * @Author: zhangb
 * @Date: 2019/3/8 16:58
 */
public class ProductCarMedFactory implements AbstractFactory {

    @Override
    public AbstractProductCarMpv createAbstractProductCarMpv() {
        return new ProductCarMedMpv();
    }

    @Override
    public AbstractProductCarSuv createAbstractProductCarSuv() {
        return new ProductCarMedSuv();
    }
}
