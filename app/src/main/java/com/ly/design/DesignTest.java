package com.ly.design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 拯救者 on 2018/2/20.
 */

public abstract class DesignTest {
    /**
     * chain
     */
    abstract class Handler {
        public Handler nextHandler;
        public int maxDay;

        public Handler(int maxDay) {
            this.maxDay = maxDay;
        }


        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        public void request(int day) {
            if (day <= maxDay) {
                reply(day);
            } else {
                if (nextHandler != null) {
                    nextHandler.request(day);
                }
            }
        }

        public abstract void reply(int day);
    }

    class ProjectManager extends Handler {
        public ProjectManager(int day) {
            super(day);
        }

        @Override
        public void reply(int day) {
            System.out.println("请假" + day + "天，项目经理审核通过");
        }
    }


    /**
     * Facde
     */
    static class ModuleA {
        public void testFunA() {
            System.out.println("this is from moduleA");
        }
    }

    static class Facde {
        private static Facde mFacde;
        private ModuleA moduleA;

        private Facde() {
            moduleA = new ModuleA();
        }

        public static Facde getInstance() {
            if (mFacde == null) {
                mFacde = new Facde();
            }
            return mFacde;
        }

        public void test() {
            moduleA.testFunA();
//            moduleB.testFunB();
        }
    }

    /**
     * 观察者
     */
    interface Observer {
        void updata(String status);
    }

    class ConcreteObserver implements Observer {

        @Override
        public void updata(String status) {
            System.out.println("收到消息" + status);
        }
    }

    abstract class Subject {
        private List<Observer> observers = new ArrayList<>();

        public void attach(Observer observer) {
            observers.add(observer);
        }

        public void detach(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers(String status) {
            for (Observer observer : observers) {
                observer.updata(status);
            }
        }

        abstract void change(String status);
    }

    class ConcreteSubject extends Subject {

        @Override
        void change(String status) {
            notifyObservers(status);
        }
    }


    /**
     * 策略
     */
    interface Strategy {
        int price(int km);
    }

    static class BusStrategy implements Strategy {

        @Override
        public int price(int km) {
            return km * 1;
        }
    }

    static class TaxiStrategy implements Strategy {

        @Override
        public int price(int km) {
            return km * 7;
        }
    }

    static class Context {
        private Strategy strategy;

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public int price(int km) {
            return strategy.price(km);
        }

        public static void main(String[] args) {
            Context context = new Context();
            context.setStrategy(new BusStrategy());
            context.price(5);
        }
    }

    /**
     * 模版
     */
    abstract class BaseActivity {

        abstract void initView();

        abstract void initData();

        void onCrete() {
            initView();
            initData();
        }
    }

    /**
     * 类适配器
     */
    class Adapter extends Adaptee implements Target {

        @Override
        public void funB() {
            System.out.println("B");
        }
    }

    interface Target {
        public void funA();

        public void funB();
    }

    class Adaptee {
        public void funA() {
            System.out.println("a");
        }
    }

    /**
     * 对象适配器
     */
    class Adapter2 implements Target {

        private Adaptee adaptee;

        public Adapter2(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void funA() {
            adaptee.funA();
        }

        @Override
        public void funB() {
            System.out.println("B");
        }
    }


    /**
     * 组合
     */
    abstract class File {
        private String name;

        File(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        void add(File file) {
        }

        void remove(File file) {
        }

        void getPosition(int positon) {
        }

        abstract void watch();
    }

    class TextFile extends File {

        TextFile(String name) {
            super(name);
        }

        @Override
        void watch() {
            System.out.println("这是一个叫" + getName() + "的文本文件");
        }
    }

    class Folder extends File {
        private List<File> folderList;

        Folder(String name) {
            super(name);
            folderList = new ArrayList();
        }

        @Override
        void add(File file) {
            folderList.add(file);
        }

        @Override
        void remove(File file) {
            folderList.remove(file);
        }

        @Override
        void getPosition(int positon) {
            folderList.get(positon);
        }


        @Override
        void watch() {
            StringBuilder stringBuilder = new StringBuilder();
            for (File file : folderList) {
                stringBuilder.append(file.getName() + ",");
            }
            System.out.println("这是一个叫" + getName() + "的文件夹，里面有" + stringBuilder.toString());
        }
    }

    /**
     * 装饰模式
     */
    interface Component{
        void operation();
    }

    static class ConcreateComponent implements Component{
        @Override
        public void operation() {
            System.out.println("from ConcreateComponent");
        }
    }

    static class Decorator implements Component{

        private Component component;
        Decorator(Component component){
            this.component=component;
        }

        @Override
        public void operation() {
            component.operation();
        }
    }

    static class ConcreateDecortoraA extends Decorator{

        ConcreateDecortoraA(Component component) {
            super(component);
            add();
        }

        private void add() {
            System.out.println("添加新功能");
        }

    }

    public static void main(String[] args) {
        ConcreateComponent concreateComponent = new ConcreateComponent();
        Decorator decorator = new Decorator(concreateComponent);
        ConcreateDecortoraA concreateDecortoraA = new ConcreateDecortoraA(decorator);

    }
}
