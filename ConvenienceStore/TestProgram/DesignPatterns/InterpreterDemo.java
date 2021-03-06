package DesignPatterns;

import calculator.*;
import java.util.HashMap;


/**
 * @className: Calculator
 * @description: 解释器模式测试程序
 * @author: Liwen Zhu
 * @date: 19:51 2019/10/26
 * @version: v1.0
 */
public class InterpreterDemo {
    public static void main(String[] args) {

        HashMap<String, Integer> ctx = null;
        ctx = Context.test();

        System.out.println("START =========================== Interpreter Demo ==========================");
        System.out.println("-- 顾客拿了1份巧克力 --");
        Calculator calc = new Calculator("h");
        int result = calc.calculate(ctx);
        System.out.println("顾客购买的商品共: " + result+"元");
        System.out.println("-------------------");

        System.out.println("-- 顾客拿了1份蛋挞和1份可乐 --");
        Calculator calc2 = new Calculator("b+g");
        int result2 = calc2.calculate(ctx);
        System.out.println("顾客购买的商品共: " + result2+"元");
        System.out.println("-------------------");

        System.out.println("-- 顾客拿了2份薯片、1份雪碧、1份巧克力和1份蛋黄酥--");
        Calculator calc3 = new Calculator("e+e+i+a");
        int result3 = calc3.calculate(ctx);
        System.out.println("顾客购买的商品共: " + result3+"元");
        System.out.println("-------------------");

        System.out.println("-- 顾客拿了1份饼干、1份饭团、1份矿泉水又决定不买矿泉水--");
        Calculator calc4 = new Calculator("c+d+f-f");
        int result4 = calc4.calculate(ctx);
        System.out.println("顾客购买的商品共: " + result4+"元");
        System.out.println("-------------------");
        System.out.println("E N D =========================== Adaptor Demo ==========================\n");
    }
}

