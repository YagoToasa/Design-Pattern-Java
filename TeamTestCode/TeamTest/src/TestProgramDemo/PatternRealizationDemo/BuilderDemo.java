package TestProgramDemo.PatternRealizationDemo;

import kitchen.merch.*;

/**
 * @className: BuilderDemo
 * @author: Shidan Cheng
 * @description:
 * @date: 1:13 下午 2019/11/7
 * @version: v1.0
 */
public class BuilderDemo {
    public static void main(String[] args) {
        System.out.println("START ========================== Builder Demo ==========================");
        Item item = new Item();
        System.out.println("> 制作水煮鱼");
        item.setBuilder(new BoiledFish());
        item.createDish();
        Dish dish = item.getDish();
        System.out.println("> 餐品名称: "+ dish.getName());
        System.out.println("> 价格名称: "+ dish.getPrice());
        System.out.println("> 制作水煮鱼[Completed]");
        System.out.println("---");
        System.out.println("> 制作麻婆豆腐");
        item.setBuilder(new MaboTofu());
        item.createDish();
        dish = item.getDish();
        System.out.println("> 餐品名称: "+ dish.getName());
        System.out.println("> 价格名称: "+ dish.getPrice());
        System.out.println("> 制作麻婆豆腐[Completed]");

        System.out.println("---");
        System.out.println("> 制作蒸馒头");
        item.setBuilder(new SteamedBread());
        item.createDish();
        dish = item.getDish();
        System.out.println("> 餐品名称: "+ dish.getName());
        System.out.println("> 价格名称: "+ dish.getPrice());
        System.out.println("> 制作蒸馒头[Completed]");

        System.out.println("---");
        System.out.println("> 制作炒青菜");
        item.setBuilder(new StirFriedVegetables());
        item.createDish();
        dish = item.getDish();
        System.out.println("> 餐品名称: "+ dish.getName());
        System.out.println("> 价格名称: "+ dish.getPrice());
        System.out.println("> 制作炒青菜[Completed]");

        System.out.println("---");
        System.out.println("> 制作鸡蛋汤");
        item.setBuilder(new EggSoup());
        item.createDish();
        dish = item.getDish();
        System.out.println("> 餐品名称: "+ dish.getName());
        System.out.println("> 价格名称: "+ dish.getPrice());
        System.out.println("> 制作鸡蛋汤[Completed]");

        System.out.println("E N D ========================== Builder Demo ==========================\n");
    }
}
