package com.ly.design;

/**
 * Created by liuyu1 on 2018/2/13.
 * 策略模式
 * 它定义了算法家庭，分别封装起来。让它们之间可以互相替换，此模式让算法的变化，不会影响到使用算法的客户。
 * 一个类定义了多种行为，并且这些行为在这个类的方法中以多个条件语句的形式出现，
 * 那么可以使用策略模式避免在类中使用大量的条件语句。
 */
public class Strategy {

    public interface AbstractStrategy {
        //按距离来计算价格
        int calculatePrice(int km);
    }

    public static class BusStrategy implements AbstractStrategy {
        @Override
        public int calculatePrice(int km) {
            return km * 1;
        }
    }

    public class TaxiStrategy implements AbstractStrategy {
        @Override
        public int calculatePrice(int km) {
            return km * 7;
        }
    }

    public static class Context {

        private AbstractStrategy strategy;

        public void setStrategy(AbstractStrategy strategy) {
            this.strategy = strategy;
        }

        public int calclatePrice(int km) {
            return strategy.calculatePrice(km);
        }

        public static void main(String[] strings) {
            Context calculator = new Context();
            calculator.setStrategy(new BusStrategy());
//        calculator.setStrategy(new TaxiStrategy());
            System.out.println("公交车20km价格：" + calculator.calclatePrice(20));
        }

    }


    /**
     * 传统写法
     * 很明显的问题就是并不是单一职责，它承担了计算公交车和地铁乘坐价格的职责的，
     * 增加一个方式出现，函数里又得增加一个判断
     */
    public static class PriceCalculator {
        private static final int TAXI = 3;
        private static final int BUS = 1;
        private static final int SUBWAY = 2;

        public static void main(String[] strings) {
            PriceCalculator calculator = new PriceCalculator();
            System.out.println("做20km公交票价：" + calculator.calculatePrice(20, BUS));
            System.out.println("做20km地铁票价：" + calculator.calculatePrice(20, SUBWAY));
        }


        private int busPrice(int km) {
            return km * 1;
        }


        public int taxiPrice(int km) {
            return km * 7;
        }

        /**
         * 根据不同类型计算
         */
        int calculatePrice(int km, int type) {
            if (type == BUS) {
                return busPrice(km);
            } else if (type == SUBWAY) {
                return taxiPrice(km);
            }
            return 0;
        }
    }

}
