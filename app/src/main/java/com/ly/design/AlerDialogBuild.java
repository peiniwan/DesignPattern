package com.ly.design;

/**
 * Created by 拯救者 on 2018/2/13.
 * 建造者模式
 * 通常用来将一个复杂的对象的构造过程分离, 让使用者可以根据需要选择创建过程.
 * 另外, 当这个复杂的对象的构造包含很多可选参数时, 也可以使用建造者模式
 */
public class AlerDialogBuild {

    private String title;
    private String message;

    public AlerDialogBuild(Builder builder) {
//        View.inflate()
        this.title = builder.title;
        this.message = builder.message;
    }

    public static class Builder {
        private String title;
        private String message;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public AlerDialogBuild build() {
            return new AlerDialogBuild(this);
        }
    }

    public static void main(String[] args) {
        new AlerDialogBuild.Builder().setTitle("").setMessage("").build();
    }
}
