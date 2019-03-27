package com.demo.designpattern.proxy;

import static org.junit.Assert.*;

/**
 * 代理模式测试
 *
 * @Author: zhangb
 * @Date: 2019-03-11 14:25
 */
public class PrinterProxyTest {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Zhangsan");
        System.out.println("现在的名字是" + p.getPrinterName() + "。");
        p.setPrinterName("Bobit");
        System.out.println("现在的名字是" + p.getPrinterName() + "。");
        p.print("Hello, world.");
    }
}