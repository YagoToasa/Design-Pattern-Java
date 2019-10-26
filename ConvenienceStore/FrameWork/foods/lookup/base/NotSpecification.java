package foods.lookup.base;

import foods.Food;

/**
 * @className: NotSpecification
 * @author: Shidan Cheng
 * @description: 非
 * @designPattern: Specification
 * @date: 11:31 下午 2019/10/25
 * @version: v1.0
 */
public class NotSpecification extends CompositeSpecification {
    public Specification spec;

    public NotSpecification(Specification spec){
        this.spec = spec;
    }

    @Override
    public boolean isSatisfiedBy(Food food) {
        return !spec.isSatisfiedBy(food);
    }
}
