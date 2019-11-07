package kitchen.staff.chef;

import kitchen.merch.Dish;
import kitchen.staff.Waiter;

import java.util.ArrayList;

public interface Target {
    /**
     * 请求获取菜品列表
     * @return ArrayList<Dish>
     */
    ArrayList<Dish> getDishes();
}
