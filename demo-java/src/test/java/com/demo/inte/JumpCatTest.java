package com.demo.inte;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试
 *
 * @Author: zhangb
 */
public class JumpCatTest {

    @Test
    public void eatsleep() {
        Cat cat = new Cat("波斯猫", 3);
        cat.eat();
        cat.sleep();
    }

    @Test
    public void eatsleepjump() {
        JumpCat jc = new JumpCat("加菲猫", 3);
        jc.eat();
        jc.sleep();
        jc.jump();
    }
}