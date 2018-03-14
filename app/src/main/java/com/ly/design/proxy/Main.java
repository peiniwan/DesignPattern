package com.ly.design.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by 拯救者 on 2018/3/12.
 */

public class Main {
    public static void main(String[] args) {
        //静态代理（我们自己静态定义的代理类)
        ProxySubject proxySubject = new ProxySubject();
        proxySubject.sellBook();

        //动态代理(通过程序动态生成代理类，该代理类不是我们自己定义的。而是由程序自动生成)
        RealSubject realSubject = new RealSubject();
        MyHandler myHandler = new MyHandler();
        myHandler.setProxySubject(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), myHandler);
        subject.sellBook();

    }
}
