package com.ly.design.decorator;

/**
 * Created by liuyu1 on 2018/2/12.
 * 装饰模式
 * <p>
 * 使用场景
 * (1)在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 * (2)当不能采用继承的方式对系统进行扩展或者采用继承不利于系统扩展和维护时可以使用装饰模式
 */
public  class DecoratorExample {

    /**
     * 抽象构件
     */
    interface Component {
        void operation();
    }

    /**
     * 具体构件
     */
    static class ConcreteComponent implements Component {

        @Override
        public void operation() {
            System.out.println("from ConcreteComponent");
        }
    }

    /**
     * 抽象装饰类
     */
    static class Decorator implements Component {
        private Component component;  //维持一个对抽象构件对象的引用

        public Decorator(Component component) { //注入一个抽象构件类型的对象
            this.component = component;
        }

        @Override
        public void operation() {
            component.operation();  //调用原有业务方法
        }
    }

    /**
     * 具体装饰类
     */
    static class ConcreteDecoratorA extends Decorator {
        public ConcreteDecoratorA(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            //俩方法位置随便替换
            super.operation();  //调用原有业务方法
            addedBehavior();  //调用新增业务方法
        }

        //新增业务方法
        public void addedBehavior() {
            System.out.println("from ConcreteDecoratorA");
        }
    }

    static class ConcreteDecoratorB extends Decorator {
        public ConcreteDecoratorB(Component component) {
            super(component);
        }

        @Override
        public void operation() {
            super.operation();
            addedBehavior();
        }

        //新增业务方法
        public void addedBehavior() {
            System.out.println("from ConcreteDecoratorB");
        }
    }

    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        Decorator decorator = new Decorator(concreteComponent);
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(decorator);
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
        concreteDecoratorB.operation();

    }
}
