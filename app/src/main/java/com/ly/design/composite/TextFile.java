package com.ly.design.composite;

/**
 * Created by liuyu1 on 2018/2/13.
 * <p>
 * Leaf : 表示叶节点对象。叶子节点没有子节点。
 */
public class TextFile extends File {

    public TextFile(String name) {
        super(name);
    }

    @Override
    public void watch() {
        System.out.println("组合模式:这是一个叫" + getName() + "文本文件");
    }
}
