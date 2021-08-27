package com.ly.design.design.single;

//一层通用拦截器，T的类型必须一致
class CInterceptSingle extends InterceptSingle<String> {

    @Override
    void intercept(String data, SingleHandler handler) {
        //拦截或者不拦截
        runtimeType = 3;
        System.out.println("CCCCCC");
        super.intercept(data, handler);

    }
}


