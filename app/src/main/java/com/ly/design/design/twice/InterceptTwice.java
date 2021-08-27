package com.ly.design.design.twice;

abstract class InterceptTwice<T> {
    boolean runtimeType;
    void onInit(T data, TwiceHandler handler) {
        handler.next(data);
    }

    void onSubmit(T data, TwiceHandler handler) {
        handler.next(data);
    }
}
