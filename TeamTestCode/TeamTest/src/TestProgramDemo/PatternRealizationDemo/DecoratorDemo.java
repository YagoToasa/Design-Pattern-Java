package TestProgramDemo.PatternRealizationDemo;

import kitchen.ingredient.FancyCut;
import kitchen.ingredient.Ingredient;
import kitchen.ingredient.Tofu;

/**
 * @className: DecoratorDemo
 * @author: Siqian Wu
 * @description:
 * @date: 12:03 2019-11-11
 * @version: v1.0
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        try {
            System.out.println("START =========================== Decorator Demo ===========================");
            System.out.println("我们创造一个实例豆腐，并用FancyCut装饰它.");
            Ingredient tofu = new Tofu();
            FancyCut fan = new FancyCut(tofu);
            fan.displayCut();
            System.out.println("豆腐处理了吗？");
            System.out.println(fan.isCut());
        }catch (Exception e){
            System.out.println("[ERROR]操作错误！");
        }
        System.out.println("E N D =========================== Decorator Demo ===========================\n");
    }
}
