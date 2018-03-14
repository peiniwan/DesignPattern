package com.ly.design.proxy;

/**
 * ReaISubject（真实主题角色）：
 * 定义了代理角色所代表的真实对象。
 */
public class RealSubject implements Subject {
    @Override
    public void sellBook() {
        System.out.println("出版社卖书");
    }
}
