package com.demo.designpattern.abstractfactory.car;

/**
 * 客户端测试
 *
 * @Author: zhangb
 * @Date: 2019/3/8 16:59
 */
public class AbstractFactoryClient {
    public static void main(String args[]) {

        AbstractFactory factory = new ProductCarMedFactory();
//        AbstractFactory factory = new ProductCarSuperFactory();
        AbstractProductCarSuv productCarSuv = factory.createAbstractProductCarSuv();
        AbstractProductCarMpv productCarMpv = factory.createAbstractProductCarMpv();
        productCarSuv.ignition();
        productCarSuv.startup();
        productCarSuv.autoStart();
        productCarMpv.ignition();
        productCarMpv.startup();
    }
}
