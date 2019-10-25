

import adapter.*;

/**
 * @className: AdaptorDemo
 * @description: 适配器模式测试
 * @author: Lanxin Liu
 * @date: 20:54 2019/10/24
 * @version: v1.0
 */
public class AdaptorDemo {
    public static void main(String[] args) {
        System.out.println("-- 顾客来到便利店门口 --");
        EatAndPowered eap = new EatAndPowered();

        System.out.println("-- 顾客选择只吃东西 --");
        eap.eat("snack","只吃东西");
        eap.eat("pastry","只吃东西");
        eap.eat("drink","只吃东西");
        System.out.println("-------------------");

        System.out.println();

        System.out.println("-- 顾客决定一边充电一边吃东西 --");
        eap.eat("安卓","一边充电一边吃东西");
        System.out.println("-------------------");
        eap.eat("苹果","一边充电一边吃东西");
        System.out.println("-------------------");
    }
}
