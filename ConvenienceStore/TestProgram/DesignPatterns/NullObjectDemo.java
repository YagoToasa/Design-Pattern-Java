package DesignPatterns;

import person.*;

/**
 * @className: NullObjectDemo
 * @author: Kunyu Chen
 * @description: Null Object模式测试类
 * @designPattern: Null Object
 * @date: 2019-10-30
 * @version: v3.0
 */
public class NullObjectDemo {
    public static void main(String[] args){
        System.out.println("START ========================= Visitor Demo =========================");

        PersonFactory personFactory = new PersonFactory();

        System.out.println("一位叫做Peter的店员前来上班——");
        //生成店员
        IsPerson person1= personFactory.getPerson("Peter","ShopAssistant");
        person1.showPerson();
        System.out.println("———");
        System.out.println("一位叫做Alex的店员前来购物——");
        //生成顾客
        IsPerson person2= personFactory.getPerson("Alex","Customer");
        person2.showPerson();
        System.out.println("———");
        System.out.println("一名叫做Tom的小偷鬼鬼祟祟——");
        //没有这个PersonType
        IsPerson person3= personFactory.getPerson("Tom","Thief");
        person3.showPerson();
        System.out.println("———");
        System.out.println("一个无名氏说他是你们的店员——");
        //名字为空
        IsPerson person4 = personFactory.getPerson(null,"ShopAssistant");
        person4.showPerson();

        System.out.println("E N D ========================= Visitor Demo =========================");
    }
}
