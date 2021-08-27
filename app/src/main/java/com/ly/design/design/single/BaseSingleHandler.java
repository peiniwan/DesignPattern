package com.ly.design.design.single;

import java.util.ArrayList;

// https://juejin.cn/post/6999875193082478600?utm_source=gold_browser_extension#heading-9

///实现init处理器
public class BaseSingleHandler extends SingleHandler {

    public ArrayList<InterceptSingle> intercepts;

    public int index;

    public BaseSingleHandler(int index, ArrayList<InterceptSingle> intercepts) {
        this.index = index;
        this.intercepts = intercepts;
    }


    @Override
    public void next(Object data) {
        super.next(data);
        if (index >= intercepts.size()) {
            return;
        }
        InterceptSingle intercept = intercepts.get(index);
        BaseSingleHandler handler = new BaseSingleHandler(index + 1, intercepts);
        intercept.intercept(data, handler);
    }
}
