package foods.lookup;

import foods.Food;
import foods.lookup.base.CompositeSpecification;

/**
 * @className: TypeIs
 * @author: Shidan Cheng
 * @description: 类型规格
 * @designPattern: Specification
 * @date: 12:22 上午 2019/10/26
 * @version: v1.0
 */
public class TypeIs extends CompositeSpecification {
    private String type;
    public TypeIs(String type){
        this.type = type;
    }

    @Override
    public boolean isSatisfiedBy(Food food) {
        return food.getType() == this.type;
    }
}
