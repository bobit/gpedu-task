package com.demo.designpattern.strategy;

/**
 * 猜拳游戏中的策略类
 *
 * @author zhangb
 */
public interface Strategy {
    public abstract Hand nextHand();

    public abstract void study(boolean win);
}
