package foods.lookup;

import foods.Food;
import foods.lookup.base.CompositeSpecification;

/**
 * @className: PriceRange
 * @author: Shidan Cheng
 * @description: 价格规格
 * @designPattern: Specification
 * @date: 12:29 上午 2019/10/26
 * @version: v1.0
 */
public class PriceRange extends CompositeSpecification {
    private String type;
    private int price;

    public PriceRange(String type, int price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public boolean isSatisfiedBy(Food food) {
        if (this.type == "=") {
            return food.getPrice() == this.price;
        } else if (this.type == ">") {
            return food.getPrice() > this.price;
        } else if (this.type == "<") {
            return food.getPrice() < this.price;
        }else if(this.type == ">="){
            return food.getPrice() >= this.price;
        }else if(this.type == "<="){
            return food.getPrice() <= this.price;
        }
        return false;
    }
}
