package adapter;

/**
 * @className: FoodToEat
 * @description: 顾客吃什么
 * @designPattern: Adapter
 * @author: Lanxin Liu
 * @date: 22:44 2019/10/25
 * @version: v1.0
 */
public interface FoodToEat {
    /**
     * 顾客吃东西
     * 
     * @methodName: eat
     * @param: type,how
     * @return: 
     */
    void eat(String type, String how);
}
