package pay.strategy;

import utils.enums.PayType;

/**
 * @className: Strategy
 * @author: Wenyue Li
 * @description: 策略 抽象类
 * @designPattern: Strategy
 * @date: 5:48 下午 2019/10/23
 */
public abstract class Strategy {
    /**
     * @methodName: solve
     * @author: Wenyue Li
     * @description: 金额的打折方式（普通和vip）
     * @date: 9:06 下午 2019/10/22
     * @param [amount]
     * @return void
     **/
    public void solve(float amount,PayType type){

    }

    /**
     * Default constructor
     */
    public Strategy() {
    }


}