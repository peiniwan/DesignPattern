package com.ly.design.design.twice;

/**
 * 抽象双方法
 */
public class Test {
    public static void main(String[] args) {
        int type = 0;
        InterceptTwiceHandler intercepts = new InterceptTwiceHandler();
        intercepts.add(new CarTypeDealIntercept());
        intercepts.add(new Car1TypeDealIntercept());
        intercepts.add(new Car2TypeDealIntercept());
        intercepts.add(new CarTypeDealIntercept());
        intercepts.onInit("传入数据源");

        //提交按钮
        intercepts.onSubmit("传入提交数据");

    }
}
