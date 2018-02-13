package com.ly.design;

/**
 * Created by liuyu1 on 2018/2/13.
 * 工厂模式
 * 工厂类可以根据条件生成不同的子类实例，这些子类有一个公共的抽象父类并且实现了相同的方法，
 * 但是这些方法针对不同的数据进行了不同的操作（多态方法）。当得到子类的实例后，开发人员可以
 * 调用基类中的方法而不必考虑到底返回的是哪一个子类的实例。
 */
public class Factory {

    /**
     * 发送邮件或者短消息的共同接口
     */
    interface Sender {
        void sender();
    }

    /**
     * 发送邮件的实现类
     */
    class MailSender implements Sender {

        @Override
        public void sender() {
            System.out.println("this is mailsender!");
        }
    }

    /**
     * 发送短信的实现类
     */
    class SMSSender implements Sender {

        @Override
        public void sender() {
            System.out.println("this is sms sender!");
        }

    }


    /**
     * 普通工厂模式
     *
     * @param type
     * @return
     */
    public Sender produce(String type) {
        if ("mial".equals(type)) {
            //根据类型生产对象
            return new MailSender();
        } else if ("sms".equals(type)) {
            //根据类型生产对象
            return new SMSSender();
        } else {
            System.out.println("类型输入错误");
            return null;
        }
    }


    /**
     * 工厂方法模式
     */
    public class SendFactory {

        public Sender produceMail() {
            return new MailSender();
        }

        public Sender produceSms() {
            return new SMSSender();
        }
    }

    /**
     * 静态工厂模式
     */
//    public class StaticSendFactory {
//
//        public static Sender produceMail() {
//            return new MailSender();
//        }
//
//        public static Sender produceSms() {
//            return new SmsSender();
//        }
//    }
    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.produce("sms");

//        SendFactory sendFactory= new SendFactory();
//        Sender sender = sendFactory.produceMail();
//        sender.sender();

//        Sender sender = SendFactory.produceMail();
//        sender.Send();
    }

}
