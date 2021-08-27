package com.ly.design.design.twice;

public class Car1TypeDealIntercept extends InterceptTwice<String>{

    @Override
    void onInit(String data, TwiceHandler handler) {
        System.out.println("Car111");
        super.onInit(data, handler);
    }

    @Override
    void onSubmit(String data, TwiceHandler handler) {
        System.out.println("提交Car111");
        super.onSubmit(data, handler);
    }
}
