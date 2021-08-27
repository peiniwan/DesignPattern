package com.ly.design.design.single;

class AInterceptSingle extends InterceptSingle<String> {

    @Override
    void intercept(String data, SingleHandler handler) {
        //拦截或者不拦截
        runtimeType = 0;
        System.out.println("AAAAAA");
        super.intercept(data, handler);
        //放这就是最后执行，也可以中间拦截
//        System.out.println("AAAAAA");

    }
}


