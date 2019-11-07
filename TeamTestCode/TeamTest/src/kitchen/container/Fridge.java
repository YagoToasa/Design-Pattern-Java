package kitchen.container;

import kitchen.ingredient.IngredientType;

import java.util.*;

/**
 * 子类冰箱
 * 此类只可放入豆腐、鱼
 * 设计模式：迭代器模式。
 * @author 谢康
 */
public class Fridge extends Container {

    /**
     * Default constructor
     */
    public Fridge() {
        if (instance == null) {
            instance = this;
            availableTypes = new ArrayList<>(Arrays.asList(
                    IngredientType.TOFU,
                    IngredientType.FISH));
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * 单例
     */
    private static Fridge instance;

    /**
     * 返回单例
     * 
     * @return instance
     */
    public static synchronized Fridge getInstance() {
        if (instance == null) {
            instance = new Fridge();
        }
        return instance;
    }

    /**
     * @return 名称
     */
    @Override
    public String getName()
    {
        return("冰箱");
    }

}