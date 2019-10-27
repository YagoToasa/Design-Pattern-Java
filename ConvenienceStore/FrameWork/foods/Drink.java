package foods;

import foods.state.FoodState;
import foods.state.Spoilage;
import utils.enums.PatternType;
import world.WorldObserver;

/**
 * @className: Drink
 * @author: Shidan Cheng
 * @description: 饮品类
 * @designPattern: Prototype, Observer, State
 * @date: 8:29 上午 2019/10/22
 * @version: v1.0
 */
public class Drink extends Food implements WorldObserver {

    public Drink(String name) {
        super(name, "饮品");
    }

    public Drink(String name, String place){
        this(name);
        this.place = place;
        if (this.place == "A工厂") {
            this.price = this.price - 1;
        }
    }


    @Override
    public Food createClone(PatternType patternType) {
        try {
            createCloneHeader(patternType);
            Food result = (Food) this.clone();
            FoodState state = (FoodState) this.state.clone();
            result.setFoodState(state, PatternType.NULL);
            return result;
        } catch (CloneNotSupportedException e) {
            System.out.println("[x]");
        }
        return null;
    }

}