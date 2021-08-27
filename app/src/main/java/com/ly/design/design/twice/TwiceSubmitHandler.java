package com.ly.design.design.twice;

import java.util.ArrayList;

public class TwiceSubmitHandler extends TwiceHandler {

    public ArrayList<InterceptTwice> intercepts;

    public int index;

    public TwiceSubmitHandler(int index, ArrayList<InterceptTwice> intercepts) {
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
        TwiceSubmitHandler handler = new TwiceSubmitHandler(index + 1, intercepts);
        intercept.onSubmit(data, handler);
    }
}
