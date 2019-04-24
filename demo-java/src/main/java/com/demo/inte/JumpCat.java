package com.demo.inte;

/**
 * 定义JumpCat继承Cat类并实现Jumping接口
 *
 * @Author: zhangb
 */
public class JumpCat extends Cat implements Jumping {
    public JumpCat() {
    }

    public JumpCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void jump() {
        System.out.println(this.getName() + "爱跳高");
    }
}
