package com.ly.design.adapter;

/**
 * Created by 拯救者 on 2018/2/13.
 * 对象适配器
 * 与类的适配器模式一样，对象的适配器模式把被适配的类的API转换成为目标类的API，
 * 与类的适配器模式不同的是，对象的适配器模式不是使用继承关系连接到Adaptee类，而是使用委派关系连接到Adaptee类。
 * 对于对象适配器，一个适配器（adaptee）可以把多种不同的源适配到同一个目标
 *
 */

public class ObjectAdapter {
    public interface Target {

        void sampleOperation1();

        void sampleOperation2();
    }

    public class Adaptee {
        public void sampleOperation1() {
            System.out.println("sampleOperation1");
        }
    }

    public class Adapter implements Target {

        private Adaptee mAdaptee;

        public Adapter(Adaptee adaptee) {
            mAdaptee = adaptee;
        }

        @Override
        public void sampleOperation1() {
            mAdaptee.sampleOperation1();
        }

        @Override
        public void sampleOperation2() {
            System.out.println("sampleOperation2");
        }

    }

    public static void main(String[] args) {
        ObjectAdapter objectAdapter = new ObjectAdapter();
        Adapter adapter = objectAdapter.new Adapter(objectAdapter.new Adaptee());
        adapter.sampleOperation1();
        adapter.sampleOperation2();
    }
}
