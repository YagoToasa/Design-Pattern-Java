package foods.lookup;

import foods.Food;
import foods.lookup.base.CompositeSpecification;

/**
 * @className: ProductBy
 * @author: Shidan Cheng
 * @description: 生产厂商 规格
 * @designPattern: Specification
 * @date: 12:25 上午 2019/10/26
 * @version: v1.0
 */
public class ProductBy extends CompositeSpecification {
    private String place;

    public ProductBy(String place){
        this.place = place;
    }

    @Override
    public boolean isSatisfiedBy(Food food) {
        return food.getPlace() == place;
    }
}
