package com.demo.designpattern.abstractfactory.car;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 客户端测试
 *
 * @Author: zhangb
 * @Date: 2019/3/8 17:18
 */
public class AbstractFactoryTest {

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

    @Test
    public void createAbstractProductCarMpv() {
    }

    @Test
    public void createAbstractProductCarSuv() {
    }
}