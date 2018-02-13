package com.ly.design.composite;

/**
 * Created by liuyu1 on 2018/2/13.
 * <p>
 * Component : 组合中的对象声明接口，在适当的情况下，实现所有类共有接口的默认行为。
 */
public abstract class File {

    private String name;

    public File(String name) {
        this.name = name;
    }

    //操作方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void watch();

    //组合方法
    public void add(File file) {
        throw new UnsupportedOperationException();
    }

    public void remove(File file) {
        throw new UnsupportedOperationException();
    }

    public File getChild(int position) {
        throw new UnsupportedOperationException();
    }
}
