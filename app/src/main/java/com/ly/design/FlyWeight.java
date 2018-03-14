package com.ly.design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyu1 on 2018/3/13.
 * 享元模式
 */
public class FlyWeight {

    static class MyString {
        private String myChar;


        public MyString(String myChar) {
            this.myChar = myChar;
        }


        public void display() {
            System.out.println(myChar);
        }
    }

    static class MyCharacterFactory {

        private Map<String, MyString> pool;

        public MyCharacterFactory() {
            pool = new HashMap<>();
        }

        public MyString getMyCharacte(String strig) {
            MyString myString = pool.get(strig);
            if (myString == null) {
                myString = new MyString(strig);
                pool.put(strig, myString);
            }
            return myString;
        }
    }

    public static void main(String[] args) {
        MyCharacterFactory myCharacterFactory = new MyCharacterFactory();
        MyString a = myCharacterFactory.getMyCharacte("a");
        MyString b = myCharacterFactory.getMyCharacte("b");
        MyString a1 = myCharacterFactory.getMyCharacte("a");
        MyString d = myCharacterFactory.getMyCharacte("d");

        if (a == a1) {
            System.out.println("true");
        }

    }
}
