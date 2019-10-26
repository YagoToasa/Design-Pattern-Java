package DesignPatterns;

import pay.strategy.CheckOutContext;
import pay.strategy.OrdinaryMemberStrategy;
import pay.strategy.PremiumMemberStrategy;
import pay.strategy.Strategy;

/**
 * @className: DesignPatterns.StrategyDemo
 * @author: Shidan Cheng
 * @description: Strategy 策略模式 测试程序
 * @date: 7:48 下午 2019/10/23
 * @version: v1.0
 */
public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("START ========================= Streategy Demo =========================");
        int payment = 100;
        System.out.println("> 现在有一名顾客等待清算结算, 其消费总金额[原]为" + payment+ "元[Completed]\n");

        CheckOutContext checkOut = new CheckOutContext();
        System.out.println("> 顾客为普通会员");
        Strategy ordinary = new OrdinaryMemberStrategy();
        System.out.printf("> 设置清算策略为普通会员清算策略");
        checkOut.setStrategy(ordinary);
        System.out.println("\t--->"+ordinary.getDiscount()*10+"折[Completed]");
        System.out.println("> 开始进行清算");
        payment = checkOut.getTotalCost(payment);
        System.out.println("> 清算完毕，应付金额为: " + payment + "元[Completed]");
        System.out.println("---");
        payment = 100;
        System.out.println("> 顾客为高级会员");
        Strategy premium = new PremiumMemberStrategy();
        System.out.printf("> 设置清算策略为高级会员清算策略");
        checkOut.setStrategy(premium);
        System.out.println("\t--->"+premium.getDiscount()*10+"折[Completed]");
        System.out.println("> 开始进行清算");
        payment = checkOut.getTotalCost(payment);
        System.out.println("> 清算完毕，应付金额为: " + payment + "元[Completed]");
        System.out.println("---");
        payment = 100;
        System.out.println("> 顾客不是会员");
        checkOut.setStrategy(null);
        System.out.println("> 开始进行清算");
        payment = checkOut.getTotalCost(payment);
        System.out.println("> 清算完毕，应付金额为: " + payment + "元[Completed]");


        System.out.println("START ========================= Streategy Demo =========================\n");
    }
}
