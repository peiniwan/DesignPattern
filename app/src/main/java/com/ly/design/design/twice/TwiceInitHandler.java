package com.ly.design.design.twice;

import java.util.ArrayList;


public class TwiceInitHandler extends TwiceHandler {

    public ArrayList<InterceptTwice> intercepts;

    public int index;

    public  TwiceInitHandler(int index, ArrayList<InterceptTwice> intercepts) {
        this.index = index;
        this.intercepts = intercepts;
    }


    @Override
    public void next(Object data) {
        super.next(data);
        if (index >= intercepts.size()) {
            return;
        }
        InterceptTwice intercept = intercepts.get(index);
        TwiceInitHandler handler = new TwiceInitHandler(index + 1, intercepts);
        intercept.onInit(data, handler);
    }
}
