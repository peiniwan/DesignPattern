package com.ly.design.design.single;

class BInterceptSingle extends InterceptSingle<String> {

    @Override
    void intercept(String data, SingleHandler handler) {
        //拦截或者不拦截
        runtimeType=1;
        System.out.println("BBBBB");
        super.intercept(data, handler);

    }
}


