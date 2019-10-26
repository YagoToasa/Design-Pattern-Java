package foods;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: FoodRepository
 * @author: Shidan Cheng
 * @description: 食品仓库
 * @designPattern: Singleton
 * @date: 8:49 下午 2019/10/25
 */
public class FoodRepository {
    private List<Food> foodList = new ArrayList<>();
    private Map<String, Integer> foodItemNumMap = new HashMap<>();

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
     * 获取食品的库存信息映射表
     *
     * @methodName: getFoodItemNumMap
     * @return: java.util.Map<java.lang.String,java.lang.Integer>
     */
    public Map<String, Integer> getFoodItemNumMap() {
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
        foodItemNumMap.put("饮品",drink);
        foodItemNumMap.put("零食",pastry);
        foodItemNumMap.put("糕点",snack);
        return foodItemNumMap;
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