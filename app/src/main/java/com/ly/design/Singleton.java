package com.ly.design;

/**
 * Created by liuyu1 on 2018/2/12.
 * 单例模式
 * 保证一个类在内存中的对象唯一性。
 */
public class Singleton {

    /**
     * 饿汉
     */
    static class HungurySingleton {
        private static HungurySingleton mSingle = new HungurySingleton();

        private HungurySingleton() {
        }

        private static HungurySingleton getInstance() {
            return mSingle;
        }
    }

    /**
     * 懒汉
     */
    static class LazySingleton {
        private static LazySingleton mSingle;

        private LazySingleton() {
        }


        private static LazySingleton getInstance() {
            if (mSingle == null) {
                mSingle = new LazySingleton();
            }
            return mSingle;
        }
    }


    /**
     * 懒汉安全
     */
    static class LazySafeSingleton {
        private static LazySafeSingleton mSingle;

        private LazySafeSingleton() {
        }


        private synchronized static LazySafeSingleton getInstance() {
            if (mSingle == null) {
                mSingle = new LazySafeSingleton();
            }
            return mSingle;
        }

        private static LazySafeSingleton getInstance1() {
            synchronized (LazySafeSingleton.class) {
                if (mSingle == null) {
                    mSingle = new LazySafeSingleton();
                }
            }
            return mSingle;
        }
    }

    /**
     * DCL
     */
    static class DCLSingleton {
        private volatile static DCLSingleton mSingle;

        private DCLSingleton() {
        }


        private static DCLSingleton getInstance() {
            if (mSingle == null) {
                synchronized (DCLSingleton.class) {
                    if (mSingle == null) {
                        mSingle = new DCLSingleton();
                    }
                }
            }
            return mSingle;
        }
    }


    /**
     * 静态内部类
     *
     * 静态变量是被static修饰符修饰的变量，也称为类变量，它属于类，不属于类的任何一个对象，
     * 一个类不管创建多少个对象，静态变量在内存中有且仅有一个拷贝，和单例的效果一样。
     * final表示变量只能一次赋值以后值不能被修改（常量）,保证了安全性。
     * 并且由于私有的属性，他人无法使用SingleHolder，不调用Singleton.getInstance()就不会创建实例。
     */
    static class StaticSingleton {
        private static final StaticSingleton mSingle = new StaticSingleton();

        private StaticSingleton() {
        }

        public static StaticSingleton getInstance() {
            return mSingle;
        }
    }

    /**
     * 枚举
     */
    public enum EnumSingleton {
        INSTANCE;

        public void doSomeThing() {
            // do something...
        }
    }

    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.INSTANCE;
        instance.doSomeThing();
    }

}
