package DesignPatterns;

import machine.*;

/**
 * @className: TemplateMethodDemo
 * @description: 模版方法测试
 * @author: Lanxin Liu
 * @designPattern: Template Method
 * @date: 00:20 2019/10/27
 * @version: v1.0
 */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        System.out.println("START ========================= Template Method Demo =========================");
        System.out.println("-- 店员：我们现在需要一杯豆浆！--");
        MakeSoyMilk soymilk = new MakeSoyMilk();
        soymilk.provideDrink();
        System.out.println("-----------------------");
        System.out.println("-- 店员：我们现在需要一杯咖啡！--");
        MakeCoffee coffee = new MakeCoffee();
        coffee.provideDrink();
        System.out.println("E N D ========================= Template Method Demo =========================\n");
    }
}
