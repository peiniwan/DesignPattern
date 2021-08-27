package com.ly.design.design.single;

/**
 * 抽象单方法
 *
 * @see <a href="https://juejin.cn/post/6999875193082478600?utm_source=gold_browser_extension#heading-26"></a>
 */
public class Test {
    public static void main(String[] args) {
        InterceptSingleHandler intercepts = new InterceptSingleHandler<String>();
        intercepts.add(new AInterceptSingle());
        intercepts.add(new BInterceptSingle());
        intercepts.add(new CInterceptSingle());
        intercepts.add(new AInterceptSingle());
        intercepts.intercept("测试拦截器");
    }
}
