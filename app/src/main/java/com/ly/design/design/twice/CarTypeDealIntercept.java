package com.ly.design.design.twice;

public class CarTypeDealIntercept  extends InterceptTwice<String>{

    @Override
    void onInit(String data, TwiceHandler handler) {
        System.out.println("Car000");
        super.onInit(data, handler);

    }

    @Override
    void onSubmit(String data, TwiceHandler handler) {
        System.out.println("提交Car000");
        super.onSubmit(data, handler);
    }
}
