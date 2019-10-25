package foods;

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
    }

    @Override
    public Food createClone(PatternType patternType) {
        try {
            createCloneHeader(patternType);
            Food result = (Food) this.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            System.out.println("[x]");
        }
        return null;
    }

    @Override
    public void update() {
        if (this.state.changeTheState()) {
            this.state = new Spoilage(this.state.getRemainDays());
        }
    }


}