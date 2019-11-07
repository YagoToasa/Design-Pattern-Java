package kitchen.merch;

import java.util.ArrayList;
/**
 * Builder模式的实现
 */
public class Item {
    /**
     * 通过创建一个Dishbuilder实例来生成菜品
     */
    private DishBuilder ndish;
    /**
     * 判断产生何种菜品
     */
    public void setBuilder(DishBuilder dish) {
        this.ndish = dish;
    }
    /**
     * 产生菜品
     */
    public void createDish(){
        ndish.setName();
        ndish.setPack();
        ndish.setPrice();
        ndish.setCooker();
        ndish.setMaterial();
        ndish.setCount();
    }
    /**
     * 生成菜品以后获取菜品的方法
     */
    public Dish getDish(){
        return ndish.getDish();
    }

}

