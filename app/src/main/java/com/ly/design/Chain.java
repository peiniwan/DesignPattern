package com.ly.design;

/**
 * Created by 拯救者 on 2018/2/13.
 * 责任链模式
 * 一个请求有多个对象来处理，这些对象是一条链，但具体由哪个对象来处理，
 * 根据条件判断来确定，如果不能处理会传递给该链中的下一个对象，直到有对象处理它为止
 */
public class Chain {

    public abstract class Handler {
        private Handler nextHandler;
        // 当前领导能审批通过的最多天数
        public int maxDay;

        protected Handler(int maxDay) {
            this.maxDay = maxDay;
        }

        //设置责任链中下一个处理请求的对象
        public void setNextHandler(Handler handler) {
            nextHandler = handler;
        }

        protected void handleRequest(int day) {
            if (day <= maxDay) {
                reply(day);
            } else {
                if (nextHandler != null) {
                    //审批权限不够，继续上报
                    nextHandler.handleRequest(day);
                } else {
                    System.out.println("没有更高的领导审批了");
                }
            }
        }

        protected abstract void reply(int day);
    }

    class ProjectManager extends Handler {
        public ProjectManager(int day) {
            super(day);
        }

        @Override
        protected void reply(int day) {
            System.out.println(day + "天请假，项目经理直接审批通过");
        }
    }

    class DepartmentManager extends Handler {
        public DepartmentManager(int day) {
            super(day);
        }

        @Override
        protected void reply(int day) {
            System.out.println(day + "天请假，部门经理审批通过");
        }
    }

    class GeneralManager extends Handler {
        public GeneralManager(int day) {
            super(day);
        }

        @Override
        protected void reply(int day) {
            System.out.println(day + "天请假，总经理直接审批通过");
        }
    }


    public static void main(String[] strings) {
        Chain chain = new Chain();
        Handler projectManager = chain.new ProjectManager(3);
        Handler departmentManager = chain.new DepartmentManager(5);
        Handler generalManager = chain.new GeneralManager(15);
        //创建职责链
        projectManager.setNextHandler(departmentManager);
        departmentManager.setNextHandler(generalManager);
        //发起请假请求
        projectManager.handleRequest(4);
    }
}
