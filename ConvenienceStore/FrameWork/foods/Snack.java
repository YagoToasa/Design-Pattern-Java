package foods;

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