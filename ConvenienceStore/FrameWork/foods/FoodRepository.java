package foods;


import utils.enums.FoodType;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: FoodRepository
 * @author: Shidan Cheng
 * @description: 食品仓库
 * @designPattern: Singleton
 * @date: 8:49 下午 2019/10/25
 */
public class FoodRepository {
    private List<Food> foodList = new ArrayList<>();

    private static class FoodRepositoryHolder {
        private static final FoodRepository INSTANCE = new FoodRepository();
    }

    private FoodRepository() {

    }

    public static final FoodRepository getInstance() {
        return FoodRepositoryHolder.INSTANCE;
    }


    /**
     * 获取仓库的总量
     *
     * @methodName: getCurrentSize
     * @param: []
     * @return: int
     */
    public int getCurrentSize() {
        return this.foodList.size();
    }

    /**
     * 向仓库中添加食品
     *
     * @methodName: addFood
     * @param: [food]
     * @return: void
     */
    public void addFood(Food food) {
        foodList.add(food);
    }

    /**
     * 从仓库中移除食品
     *
     * @methodName: removeFood
     * @param: [food]
     * @return: boolean
     */
    public boolean removeFood(Food food) {
        return foodList.remove(food);
    }

    /**
     * 显示仓库内食品的详细信息
     *
     * @methodName: show
     * @return: void
     */
    public void show() {
        for (Food food : foodList) {
            food.describeFoodLifeInformation();
        }
    }

    /**
     * 统计食品的库存信息并打印
     *
     * @methodName: countItemsByType
     * @return: void
     */
    public void countItemsByType() {
        int drink = 0;
        int pastry = 0;
        int snack = 0;
        for (Food food : foodList) {
            if (food.getType() == "饮品") {
                drink++;
            } else if (food.getType() == "零食") {
                snack++;
            } else {
                pastry++;
            }
        }
        System.out.println("> 仓库剩余饮品总数目: " + drink);
        System.out.println("> 仓库剩余零食总数目: " + snack);
        System.out.println("> 仓库剩余糕点总数目: " + pastry);
    }

    /**
     * 获取仓库内食品列表
     *
     * @methodName: getFoodList
     * @return: java.util.List<foods.Food>
     */
    public List<Food> getFoodList() {
        return foodList;
    }
}