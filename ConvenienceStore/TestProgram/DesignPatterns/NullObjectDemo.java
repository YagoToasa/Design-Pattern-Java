package DesignPatterns;

import person.*;

/**
 * @className: NullObjectDemo
 * @author: Kunyu Chen
 * @description: Null Object模式测试类
 * @designPattern: Null Object
 * @date: 2019-10-27
 * @version: v2.0
 */
public class NullObjectDemo {
    public static void main(String[] args){
        System.out.println("START ========================= Visitor Demo =========================");

        PersonFactory personFactory = new PersonFactory();

        //生成店员
        IsPerson person1= personFactory.getPerson("Peter","ShopAssistant");
        person1.showPerson();
        //生成顾客
        IsPerson person2= personFactory.getPerson("Alex","Customer");
        person2.showPerson();
        //没有这个PersonType
        IsPerson person3= personFactory.getPerson("Alex","Cook");
        person3.showPerson();
        //名字为空
        IsPerson person4 = personFactory.getPerson(null,"ShopAssistant");
        person4.showPerson();

        System.out.println("E N D ========================= Visitor Demo =========================");
    }
}
