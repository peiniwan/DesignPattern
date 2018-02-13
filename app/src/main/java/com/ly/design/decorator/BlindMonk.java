package com.ly.design.decorator;

/**
 * Created by liuyu1 on 2018/2/12.
 * ConcreteComponent 具体英雄盲僧
 */
public class BlindMonk implements Hero {

    private String name;

    public BlindMonk(String name) {
        this.name = name;
    }

    @Override
    public void learnSkills() {
        System.out.println(name + "学习了以上技能！");
    }
}
