package com.ly.design.decorator;

/**
 * Created by liuyu1 on 2018/2/12.
 * ConreteDecorator 技能：Q
 */
public class Skill_Q extends Skills {

    private String skillName;

    public Skill_Q(Hero hero, String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能Q:" + skillName);
        super.learnSkills();
    }
}