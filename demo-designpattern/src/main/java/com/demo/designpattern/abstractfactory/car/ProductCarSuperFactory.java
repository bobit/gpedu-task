package com.demo.designpattern.abstractfactory.car;

/**
 * 具体工厂角色 高配
 *
 * @Author: zhangb
 * @Date: 2019/3/8 16:56
 */
public class ProductCarSuperFactory implements AbstractFactory {
    @Override
    public AbstractProductCarMpv createAbstractProductCarMpv() {
        return new ProductCarSuperMpv();
    }

    @Override
    public AbstractProductCarSuv createAbstractProductCarSuv() {
        return new ProductCarSuperSuv();
    }
}
