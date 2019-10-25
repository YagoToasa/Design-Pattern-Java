import foods.Drink;
import foods.Food;
import foods.Pastry;
import foods.Snack;
import foods.lookup.*;
import foods.lookup.base.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: SpecificationDemo
 * @description: Specification 规格模式 测试程序
 * @author: Shidan Cheng
 * @date: 11:50 下午 2019/10/25
 * @version: v1.0
 */
public class SpecificationDemo {
    public static List<Food> initFoodList() {
        System.out.println("> 初始化供货列表");
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Drink("可乐", "A工厂"));
        foodList.add(new Drink("可乐", "B工厂"));
        foodList.add(new Drink("雪碧", "A工厂"));
        foodList.add(new Drink("雪碧", "B工厂"));
        foodList.add(new Drink("矿泉水", "A工厂"));
        foodList.add(new Drink("矿泉水", "B工厂"));
        foodList.add(new Pastry("蛋挞", "A工厂"));
        foodList.add(new Pastry("蛋挞", "B工厂"));
        foodList.add(new Pastry("饭团", "A工厂"));
        foodList.add(new Pastry("饭团", "B工厂"));
        foodList.add(new Pastry("蛋黄酥", "A工厂"));
        foodList.add(new Pastry("蛋黄酥", "B工厂"));
        foodList.add(new Snack("巧克力", "A工厂"));
        foodList.add(new Snack("巧克力", "B工厂"));
        foodList.add(new Snack("饼干", "A工厂"));
        foodList.add(new Snack("饼干", "B工厂"));
        foodList.add(new Snack("薯片", "A工厂"));
        foodList.add(new Snack("薯片", "B工厂"));
        System.out.println("> 初始化供货列表 [Completed]");
        return foodList;
    }


    public static void main(String[] args) {
        System.out.println("START ======================= Specification Demo =======================");
        List<Food> foodList = initFoodList();
        foodList.forEach((food)->{
            System.out.printf("食品-名称: %s\t类型: %s\t生产方: %s\t价格: %d元\n",food.getName(),food.getType(),food.getPlace(),food.getPrice());
        });
        System.out.println("---");
        Specification spec;
        System.out.println("> 从供货列表中选取名称为\"可乐\"或\"巧克力\"的食品");
        spec = new NameIs("可乐").or(new NameIs("巧克力"));
        for (Food food : foodList) {
            if (spec.isSatisfiedBy(food)){
                System.out.printf("食品-名称: %s\t类型: %s\t生产方: %s\t价格: %d元\n",food.getName(),food.getType(),food.getPlace(),food.getPrice());
            }
        }
        System.out.println("> 从供货列表中选取\"B工厂\"生产的价格\"高于3元且小于等于6元\"的\"零食\"或\"糕点\"");
        spec = new ProductBy("B工厂").and(new PriceRange(">",3)).and(new PriceRange("<=",6)).and(new TypeIs("零食").or(new TypeIs("糕点")));
        for (Food food : foodList) {
            if (spec.isSatisfiedBy(food)){
                System.out.printf("食品-名称: %s\t类型: %s\t生产方: %s\t价格: %d元\n",food.getName(),food.getType(),food.getPlace(),food.getPrice());
            }
        }

        System.out.println("> 从供货列表中选取\"B工厂或A工厂\"生产的价格\"低于4元\"的\"饮品\"食品");
        spec = new ProductBy("A工厂").or(new ProductBy("B工厂")).and(new PriceRange("<",4)).and(new TypeIs("饮品"));
        for (Food food : foodList) {
            if (spec.isSatisfiedBy(food)){
                System.out.printf("食品-名称: %s\t类型: %s\t生产方: %s\t价格: %d元\n",food.getName(),food.getType(),food.getPlace(),food.getPrice());
            }
        }


        System.out.println("E N D ======================= Specification Demo =======================\n");
    }
}
