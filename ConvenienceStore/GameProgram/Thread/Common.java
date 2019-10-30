package GameProgram.Thread;

import calculator.Calculator;
import foods.Food;
import foods.FoodRepository;
import person.*;
import store.ConvenienceStore;
import store.message.CustomerMessageBoard;
import store.message.Mediator;
import utils.info.PriceTable;
import world.WorldClock;

import java.util.*;

/**
 * @className: Common
 * @author: Shidan Cheng
 * @description: 公共变量
 * @date: 6:07 下午 2019/10/27
 * @version: v1.0
 */
public class Common {
    public static ConvenienceStore convenienceStore = ConvenienceStore.getInstance();
    public static FoodRepository foodRepository = FoodRepository.getInstance();
    public static CustomerFactory customerFactory = CustomerFactory.getInstance();
    public static WorldClock worldClock = WorldClock.getInstance();
    public static ShopKeeper shopKeeper = ShopKeeper.getInstance();
    public static ShopAssistantFactory shopAssistantFactory = ShopAssistantFactory.getInstance();
    public static List<Customer> customerList = new ArrayList<>();
    public static List<ShopAssistant> shopAssistantList = new ArrayList<>();
    public static Mediator messageBoard = new CustomerMessageBoard();
    public static List<Food> foodPrototypeList;

    public static Map<Integer, String> customerBuyMap = new HashMap<>();

    static {
        customerBuyMap.put(0, "A套餐");
        customerBuyMap.put(1, "B套餐");
        customerBuyMap.put(2, "办理高级会员卡");
        customerBuyMap.put(3, "办理普通会员卡");
        customerBuyMap.put(4, "可乐");
        customerBuyMap.put(5, "雪碧");
        customerBuyMap.put(6, "矿泉水");
        customerBuyMap.put(7, "巧克力");
        customerBuyMap.put(8, "饼干");
        customerBuyMap.put(9, "薯片");
        customerBuyMap.put(10, "蛋挞");
        customerBuyMap.put(11, "饭团");
        customerBuyMap.put(12, "蛋黄酥");
    }

    public static Map<String, String> VisitorsMap = new HashMap<>();

    static{
        VisitorsMap.put("Tom", "Thief");
        VisitorsMap.put(null, "ShopAssistant");
        VisitorsMap.put("Susan",null);
    }



}
