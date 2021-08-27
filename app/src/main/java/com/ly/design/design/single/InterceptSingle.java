package com.ly.design.design.single;

//一层通用拦截器，T的类型必须一致
abstract class InterceptSingle<T> {
    int runtimeType;

    void intercept(T data, SingleHandler handler) {
        handler.next(data);
    }
}


