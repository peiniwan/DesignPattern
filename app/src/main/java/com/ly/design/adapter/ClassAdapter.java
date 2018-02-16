package com.ly.design.adapter;

/**
 * Created by 拯救者 on 2018/2/13.
 * 适配器模式
 *
 * 把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起使用的类能够一起工作。
 * 适配器就是一种适配中间件，它存在于不匹配的二者之间，用于连接二者，将不匹配变得匹配，
 * 简单点理解就是平常所见的转接头，转换器之类的存在。
 *
 * 类适配器
 * 通过继承来实现适配器功能。
 * 对于类适配器，由于适配器直接继承了Adaptee，使得适配器不能和 Adaptee的子类一起工作
 */
public class ClassAdapter {
    public interface Target {

        void sampleOperation1();

        void sampleOperation2();
    }

    public class Adaptee {

        public void sampleOperation1() {
            System.out.println("sampleOperation1");
        }
    }

    public class Adapter extends Adaptee implements Target {

        @Override
        public void sampleOperation2() {
            System.out.println("sampleOperation2");
        }

    }

    public static void main(String[] args) {
        ClassAdapter classAdapter = new ClassAdapter();
        Adapter adapter = classAdapter.new Adapter();
        adapter.sampleOperation1();
        adapter.sampleOperation2();
    }
}
