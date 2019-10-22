package foods;

import foods.state.Normal;
import foods.state.Spoilage;
import utils.info.ConstantTable;
import utils.info.PriceTable;
import world.WorldObserver;

/**
 * @className: Pastry
 * @author: Shidan Cheng
 * @description: 糕点类
 * @designPattern: Prototype, Observer
 * @date: 8:30 上午 2019/10/22
 * @version: v1.0
 */
public class Pastry extends Food implements WorldObserver {

    public Pastry(String name){
        super(name, "糕点");
    }

    @Override
    public Food createClone() {
        try{
            return (Food) this.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update() {
        this.remainDays = this.remainDays - 1;
        if (this.remainDays == 0){
            this.state = new Spoilage();
        }
    }
}