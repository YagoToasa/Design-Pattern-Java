import factory.AbstractFactory;
import factory.CustomerFactory;
import factory.FoodFactory;
import factory.ShopAssistantFactory;
import foods.Food;
import person.Customer;
import utils.info.ConstantTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @className: AbstractFactoryDemo
 * @description: AbstractFactory 抽象工厂模式 测试程序
 * @author: Shidan Cheng
 * @date: 6:43 下午 2019/10/22
 * @version: v1.0
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("START ====================== AbstractFactory Demo ======================");
        AbstractFactory foodFactory = FoodFactory.getInstance();
        Set<String> nameSet = ConstantTable.FOOD_ITEM_TYPE_MAP.keySet();
        List<Food> foodList = new ArrayList<>();
        System.out.println("> 开始生产食品");

        for (String key : nameSet) {
            Food food = foodFactory.createFood(key);
            System.out.printf(">>> 生成-食品-名称: %s\t类型: %s[√]\n",key.toString(),food.getType());
            foodList.add(food);
        }
        System.out.println("> 开始生产食品 [Completed]");


        System.out.println("E N D ====================== AbstractFactory Demo ======================\n");
    }
}
