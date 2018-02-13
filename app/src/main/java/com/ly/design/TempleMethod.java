package com.ly.design;

/**
 * Created by liuyu1 on 2018/2/13.
 * 模板方法
 * 提供一个抽象类，将部分逻辑以具体方法或构造器的形式实现，然后声明一些抽象方法来迫使子类实现剩余的逻辑。
 * 不同的子类可以以不同的方式实现这些抽象方法（多态实现），从而实现不同的业务逻辑。
 * 使用场景
 * 1)多个子类有公有的方法，并且逻辑基本相同时
 * 2)重要、复杂的算法，可以把核心算法设计为模板方法
 * 3)重构时，模板方法模式是一个经常使用的模式
 */
public class TempleMethod {

    abstract class AbstractWork {

        protected void getUp() {
            System.out.println("起床啦！");
        }

        protected abstract void goToWork();

        protected abstract void work();

        protected abstract void getOffWork();

        /**
         * TemplateMethod，大家都拥有共同的执行步骤
         */
        public final void newDay() {
            getUp();
            goToWork();
            work();
            getOffWork();
        }
    }

    class BossWork extends AbstractWork {

        @Override
        protected void goToWork() {
            System.out.println("老板开车去上班");
        }

        @Override
        protected void work() {
            System.out.println("老板的分配工作给员工");
        }

        @Override
        protected void getOffWork() {
            System.out.println("老板开车去下班");
        }

    }

    class StaffWork extends AbstractWork {

        @Override
        protected void goToWork() {
            System.out.println("员工做公交去上班");

        }

        @Override
        protected void work() {
            System.out.println("员工处理具体工作");
        }

        @Override
        protected void getOffWork() {
            System.out.println("员工做公交下班");
        }
    }

    public static void main(String[] args) {
        TempleMethod templeMethod = new TempleMethod();
        BossWork bossWork = templeMethod.new BossWork();
        StaffWork staffWork = templeMethod.new StaffWork();
        bossWork.newDay();
        System.out.println("------------------------");
        staffWork.newDay();
    }


}
