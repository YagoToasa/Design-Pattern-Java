package foods;

import foods.state.FoodState;
import foods.state.Normal;
import foods.state.Spoilage;
import utils.enums.PatternType;
import utils.info.ConstantTable;
import utils.info.PriceTable;
import world.WorldObserver;

/**
 * @className: Pastry
 * @author: Shidan Cheng
 * @description: 糕点类
 * @designPattern: Prototype, Observer, State
 * @date: 8:30 上午 2019/10/22
 * @version: v1.0
 */
public class Pastry extends Food implements WorldObserver {

    public Pastry(String name) {
        super(name, "糕点");
    }
    public Pastry(String name, String place){
        this(name);
        this.place = place;
        if (this.place == "A工厂") {
            this.price = this.price + 1;
        }
    }

    @Override
    public Food createClone(PatternType patternType) {
        try {
            createCloneHeader(patternType);
            Food result =  (Food) this.clone();
            FoodState state = (FoodState) this.state.clone();
            result.setFoodState(state,PatternType.NULL);
            return result;
        } catch (CloneNotSupportedException e) {
            System.out.println("[x]");
        }
        return null;
    }


}