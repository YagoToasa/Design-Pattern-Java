package DesignPatterns;

import cards.CardFactory;
import cards.MembershipCard;
import cards.OrdinaryCardFactory;
import cards.SeniorCardFactory;

/**
 * @className: DesignPatterns.FactoryMethodDemo
 * @author: Yinan Cheng
 * @description: Factory method 工厂模式 测试程序
 * @date: 19:59 2019/10/23
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        System.out.println("START ====================== Factory Method Demo =======================");
        CardFactory ordinaryCardFactory=new OrdinaryCardFactory();
        MembershipCard cardOrdinary=ordinaryCardFactory.getCard("顾客A");
        cardOrdinary.showMemberShipCard();

        CardFactory seniorCardFactory=new SeniorCardFactory();
        MembershipCard cardSenior=seniorCardFactory.getCard("顾客B");
        cardSenior.showMemberShipCard();
        System.out.println("E N D ====================== Factory Method Demo =======================\n");
    }
}
