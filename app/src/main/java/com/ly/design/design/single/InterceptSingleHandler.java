package com.ly.design.design.single;

import java.util.ArrayList;

///添加拦截器,触发拦截器方法入口
public class InterceptSingleHandler<T> {

    private final BaseSingleHandler handler;

    public InterceptSingleHandler() {
        handler = new BaseSingleHandler(0, new ArrayList<InterceptSingle>());
    }


    public void add(InterceptSingle intercept) {
        //一种类型的拦截器只能添加一次
//        for (InterceptSingle item : handler.intercepts) {
//            if (item.runtimeType == intercept.runtimeType) {
//                return;
//            }
//        }
        handler.intercepts.add(intercept);
    }

    public void delete(InterceptSingle intercept) {
        handler.intercepts.remove(intercept);
    }


    public void intercept(T data) {
        handler.next(data);
    }


}
