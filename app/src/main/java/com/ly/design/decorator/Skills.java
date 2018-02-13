package com.ly.design.decorator;

/**
 * Created by liuyu1 on 2018/2/12.
 * Decorator 技能栏
 */
public class Skills implements Hero {

    //持有一个英雄对象接口
    private Hero hero;

    public Skills(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void learnSkills() {
        if (hero != null) {
            hero.learnSkills();
        }
    }
}