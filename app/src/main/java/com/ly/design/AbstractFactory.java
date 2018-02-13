package com.ly.design;

/**
 * Created by liuyu1 on 2018/2/13.
 * 抽象工厂
 * 工厂方法模式有一个问题就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，
 * 这违背了闭包原则。抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，
 * 不需要修改之前的代码。
 */
public class AbstractFactory {
    interface Sender {
        void Send();
    }

    interface Provider {
        Sender produce();
    }

    public class MailSender implements Sender {
        @Override
        public void Send() {
            System.out.println("this is mailsender!");
        }
    }

    public class SmsSender implements Sender {

        @Override
        public void Send() {
            System.out.println("this is sms sender!");
        }
    }

    public class SendMailFactory implements Provider {

        @Override
        public Sender produce() {
            return new MailSender();
        }
    }

    public class SendSmsFactory implements Provider {

        @Override
        public Sender produce() {
            return new SmsSender();
        }
    }

    public static void main(String[] args) {
//        Provider provider = new SendMailFactory();
//        Sender sender = provider.produce();
//        sender.Send();
    }


}
