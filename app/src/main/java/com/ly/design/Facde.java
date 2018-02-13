package com.ly.design;

/**
 * Created by liuyu1 on 2018/2/12.
 * 外观模式
 *
 * 外观模式的主要目的在于让外部减少与子系统内部多个模块的交互，从而让外部能够更简单得使用子系统。
 * 它负责把客户端的请求转发给子系统内部的各个模块进行处理。
 * 使用场景
 * 1)当你要为一个复杂子系统提供一个简单接口时。
 * 1)由于Facade类封装了各个模块交互的过程，如果今后内部模块调用关系发生了变化，只需要修改Facade实现就可以了。
 * 2) Facade实现是可以被多个客户端调用的
 */
public class Facde {

    class ModuleA {
        public void testFunA() {
            System.out.println("This is Function From ModuleA");
        }
    }

    class ModuleB {
        public void testFunB() {
            System.out.println("This is Function From ModuleB");
        }
    }

    private ModuleA moduleA;
    private ModuleB moduleB;
    private static Facde mFacde;

    private Facde() {
        moduleA = new ModuleA();
        moduleB = new ModuleB();
    }

    public static Facde getInstance() {
        if (mFacde == null) {
            mFacde = new Facde();
        }
        return mFacde;
    }

    public void testOperation() {
        moduleA.testFunA();
        moduleB.testFunB();
    }

    public static void main(String[] args) {
        Facde.getInstance().testOperation();
    }
}
