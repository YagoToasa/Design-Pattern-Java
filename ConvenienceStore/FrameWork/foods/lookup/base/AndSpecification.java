package foods.lookup.base;

import foods.Food;

/**
 * @className: AndSpecification
 * @author: Shidan Cheng
 * @description: 与
 * @designPattern: Specification
 * @date: 11:31 下午 2019/10/25
 * @version: v1.0
 */
public class AndSpecification extends CompositeSpecification {
    private Specification left;
    private Specification right;

    public AndSpecification(Specification left, Specification right){
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfiedBy(Food food) {
        return left.isSatisfiedBy(food) && right.isSatisfiedBy(food);
    }
}
