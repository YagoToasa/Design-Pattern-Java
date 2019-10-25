package foods.lookup;

import foods.Food;
import foods.lookup.base.CompositeSpecification;

/**
 * @className: NameIs
 * @author: Shidan Cheng
 * @description: 名称规格
 * @designPattern: Specification
 * @date: 12:23 上午 2019/10/26
 * @version: v1.0
 */
public class NameIs extends CompositeSpecification {
    private String name;
    public NameIs(String name){
        this.name = name;
    }

    @Override
    public boolean isSatisfiedBy(Food food) {
        return food.getName() == this.name;
    }
}
