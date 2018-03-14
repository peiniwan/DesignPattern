package com.ly.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 拯救者 on 2018/3/12.
 */

public class MyHandler implements InvocationHandler {
    private RealSubject realSubject;

    public void setProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }


    /**
     * @param proxy  　指代我们所代理的那个真实对象
     * @param method   指代的是我们所要调用真实对象的某个方法的Method对象
     * @param args   　指代的是调用真实对象某个方法时接受的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        sale();
        proxy = method.invoke(realSubject, args);
        give();
        return proxy;
    }

    public void sale() {
        System.out.println("打折");
    }

    public void give() {
        System.out.println("送优惠券");
    }
}
