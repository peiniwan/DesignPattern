package com.ly.design.composite;

/**
 * Created by liuyu1 on 2018/2/13.
 * 组合模式
 * <p>
 * 组合模式使得用户对单个对象和组合对象的使用具有一致性。
 * 将对象组合成树形结构以表示“部分-整体”的层次结构。
 */
public class Composite {

    public static void main(String[] strings) {
        TextFile textFileA = new TextFile("a.txt");
        TextFile textFileB = new TextFile("b.txt");
        TextFile textFileC = new TextFile("c.txt");

        textFileA.watch();
//        textFileA.add(textFileB);//调用会抛我们在抽象接口中写的异常

        Folder folder = new Folder("学习资料");
        folder.add(textFileA);
        folder.add(textFileB);
        folder.add(textFileC);
        folder.watch();
        folder.getChild(1).watch();

        Folder folder1 = new Folder("个人资料");
        folder1.add(textFileA);
        folder1.add(textFileB);

        //可以随便组合
        Folder folder2 = new Folder("D盘资料");
        folder2.add(folder);
        folder2.add(folder1);
        folder2.watch();

    }

}
