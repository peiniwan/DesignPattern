package com.ly.design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyu1 on 2018/2/13.
 * 观察者模式
 * 定义对象之间的一种一对多依赖关系，使得每当一个对象状态发生改变时，其相关依赖对象皆可得到通知并被自动更新。
 */

public class ObserverPattern {

    public interface Observer {
        void update(String state);
    }

    public class ConcreteObserver implements Observer {
        // 观察者状态
        private String observerState;

        @Override
        public void update(String state) {
            // 更新观察者状态，让它与目标状态一致
            observerState = state;
            System.out.println("ConcreteObserver State :" + observerState);
        }
    }

    /**
     * 抽象订阅者（目标者）
     * 被观察者
     */
    public abstract class Subject {

        // 保存注册的观察者对象
        private List<Observer> mObservers = new ArrayList<>();

        //注册观察者对象
        public void attach(Observer observer) {
            mObservers.add(observer);
            System.out.println("Attached an observer");
        }

        //注销观察者对象
        public void detach(Observer observer) {
            mObservers.remove(observer);
        }

        // 通知所有注册的观察者对象
        public void nodifyObservers(String newState) {
            for (Observer observer : mObservers) {
                observer.update(newState);
            }
        }
    }

    public class ConcreteSubject extends Subject {

        private String state;

        public String getState() {
            return state;
        }

        public void change(String newState) {
            state = newState;
            System.out.println("ConcreteSubject State:" + state);
            //状态发生改变，通知观察者
            nodifyObservers(state);
        }
    }

    public static void main(String[] args) {
        ObserverPattern observerPattern = new ObserverPattern();
        ConcreteSubject concreteSubject = observerPattern.new ConcreteSubject();
        Observer observer1 = observerPattern.new ConcreteObserver();
        Observer observer2 = observerPattern.new ConcreteObserver();
        // 将观察者对象注册到目标对象上
        concreteSubject.attach(observer1);
        concreteSubject.attach(observer2);
        // 改变目标对象的状态
        concreteSubject.change("I change");
    }
}
