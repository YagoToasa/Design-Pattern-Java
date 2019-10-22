import foods.Drink;
import foods.Food;
import foods.state.FoodState;
import foods.state.Normal;
import foods.state.Spoilage;

/**
 * @className: StateDemo
 * @description: State 状态模式 测试程序
 * @author: Shidan Cheng
 * @date: 12:39 下午 2019/10/22
 * @version: v1.0
 */
public class StateDemo {
    public static void main(String[] args) {
        System.out.println("START =========================== State Demo ===========================");
        FoodState normal = new Normal(10);
        FoodState normalNearSpoilage = new Normal(1);
        FoodState spoilage = new Spoilage(0);
        Food cola = new Drink("可乐");
        cola.describeFoodDetailInformation();
        System.out.println("---");
        cola.setFoodState(normal);
        cola.describeFoodDetailInformation();
        System.out.println("---");
        cola.setFoodState(normalNearSpoilage);
        cola.describeFoodDetailInformation();
        System.out.println("---");
        cola.setFoodState(spoilage);
        cola.describeFoodDetailInformation();
        System.out.println("E N D =========================== State Demo ===========================\n");
    }
}
