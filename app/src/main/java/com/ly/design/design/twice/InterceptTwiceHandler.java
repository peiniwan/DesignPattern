package com.ly.design.design.twice;

import java.util.ArrayList;

public class InterceptTwiceHandler {

    private final TwiceInitHandler init;
    private final TwiceSubmitHandler submit;

    public InterceptTwiceHandler() {
        init = new TwiceInitHandler(0, new ArrayList<InterceptTwice>());
        submit = new TwiceSubmitHandler(0, new ArrayList<InterceptTwice>());
    }


    public void add(InterceptTwice intercept) {
        //一种类型的拦截器只能添加一次
//        for (InterceptTwice item : init.intercepts) {
//            if (item.runtimeType == intercept.runtimeType) {
//                return;
//            }
//        }
        init.intercepts.add(intercept);
        submit.intercepts.add(intercept);

    }

    public void delete(InterceptTwice intercept) {
        init.intercepts.remove(intercept);
        submit.intercepts.remove(intercept);
    }


    public void onInit(Object data) {
        init.next(data);
    }

    public void onSubmit(Object data) {
        submit.next(data);
    }
}
