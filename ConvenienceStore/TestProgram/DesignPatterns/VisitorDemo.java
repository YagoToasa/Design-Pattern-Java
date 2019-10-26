package DesignPatterns;

import decoration.furniture.*;
import decoration.visitor.*;

/**
 * @className: DesignPatterns.VisitorDemo
 * @author: Siqian Wu
 * @description: Visitor模式测试类
 * @designPattern: Visitor
 * @date: 18:00 2019-10-24
 * @version: v1.0
 */
public class VisitorDemo {
    public static void main(String[] args){
        System.out.println("START ========================= Visitor Demo =========================");

        Chair chair =new Chair();
        Desk desk = new Desk();
        Chair chair1 =new Chair("实木");
        Desk desk1 = new Desk("实木");

        //对普通桌椅设置夏季装扮
        chair.accept(new SummerVisitor());
        desk.accept(new SummerVisitor());

        //对普通桌椅设置冬季装扮
        chair.accept(new WinterVisitor());
        desk.accept(new WinterVisitor());

        //对实木桌椅设置夏季装扮
        chair1.accept(new SummerVisitor());
        desk1.accept(new SummerVisitor());

        //对实木桌椅设置冬季装扮
        chair1.accept(new WinterVisitor());
        desk1.accept(new WinterVisitor());

        System.out.println("E N D ========================= Visitor Demo =========================");
    }
}
