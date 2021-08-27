package com.ly.design.design.twice;

public class Car2TypeDealIntercept extends InterceptTwice<String>{

    @Override
    void onInit(String data, TwiceHandler handler) {
        System.out.println("Car222");
        super.onInit(data, handler);
    }

    @Override
    void onSubmit(String data, TwiceHandler handler) {
        super.onSubmit(data, handler);
        System.out.println("提交Car222");
    }
}
