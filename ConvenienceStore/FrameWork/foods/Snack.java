package foods;

import foods.state.FoodState;
import foods.state.Normal;
import foods.state.Spoilage;
import utils.enums.PatternType;
import utils.info.ConstantTable;
import utils.info.PriceTable;
import world.WorldObserver;

/**
 * @className: Snack
 * @author: Shidan Cheng
 * @description: 零食类
 * @designPattern: Prototype, Observer, State
 * @date: 8:29 上午 2019/10/22
 * @version: v1.0
 */
public class Snack extends Food implements WorldObserver {

    public Snack(String name) {
        super(name, "零食");
    }

    public Snack(String name, String place){
        this(name);
        this.place = place;
    }
    @Override
    public Food createClone(PatternType patternType) {
        try {
            createCloneHeader(patternType);
            Food result = (Food) this.clone();
            FoodState state = (FoodState) this.state.clone();
            result.setFoodState(state,PatternType.NULL);
            return result;
        } catch (CloneNotSupportedException e) {
            System.out.println("[x]");
        }
        return null;
    }

}