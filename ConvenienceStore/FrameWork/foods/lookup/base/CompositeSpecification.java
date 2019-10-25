package foods.lookup.base;

import foods.Food;

/**
 * @className: CompositeSpecification
 * @author: Shidan Cheng
 * @description: 组合规范 抽象类
 * @designPattern: Specification
 * @date: 11:29 下午 2019/10/25
 * @version: v1.0
 */
public abstract class CompositeSpecification implements Specification {
    @Override
    public Specification and(Specification spec) {
        return new AndSpecification(this,spec);
    }

    @Override
    public Specification or(Specification spec) {
        return new OrSpecification(this,spec);
    }

    @Override
    public Specification not() {
        return new NotSpecification(this);
    }

    @Override
    public abstract boolean isSatisfiedBy(Food food);
}
