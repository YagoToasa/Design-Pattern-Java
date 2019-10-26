package DesignPatterns;

import person.*;
import java.util.*;
/**
 * @className: DesignPatterns.CompositeDemo
 * @description: COMPOSITE PATTERN TEST
 * @author: Lanxin Liu
 * @date: 20:03 2019/10/25
 * @version: v1.0
 */
public class CompositeDemo {
    public static void main(String[] args) {
        System.out.println("START =========================== Composite Demo ==========================");
        ShopKeeper shopkeeper = ShopKeeper.getInstance();
        ShopAssistant sa1 = new ShopAssistant("SA1","收银");
        ShopAssistant sa2 = new ShopAssistant("SA2","清洁");
        ShopAssistant sa3 = new ShopAssistant("SA3","会计");
        shopkeeper.addAssistant(sa1);
        shopkeeper.addAssistant(sa2);
        shopkeeper.addAssistant(sa3);
        System.out.println("店员招纳完毕了！");

        System.out.println("--------------------");

        System.out.println("顾客买完东西来结账了...");
        ShopAssistant sy = whoDeal(shopkeeper.getSAList(),"收银");
        sy.dealProblem();
        System.out.println("顾客打翻了饮料，地面脏了TAT");
        ShopAssistant qj = whoDeal(shopkeeper.getSAList(),"收银");
        qj.dealProblem();
        System.out.println("今天的工作结束了，应该统计一下今天的收入了！");
        ShopAssistant kj = whoDeal(shopkeeper.getSAList(),"收银");
        kj.dealProblem();

        System.out.println("--------------------");

        System.out.println();
        System.out.println("会计卷款潜逃了！");
        shopkeeper.deleteAssistant(sa3);
        System.out.println("--------------------");

        shopkeeper.printList();
        
        System.out.println("E N D =========================== Composite Demo ==========================\n");

    }

    private static ShopAssistant whoDeal(ArrayList<ShopAssistant> saList, String duty) {
        ShopAssistant sa = null;
        for(ShopAssistant s: saList) {
            if(duty.equals(s.getDuty())) {
                sa = s;
            }
        }
        return sa;
    }
}
