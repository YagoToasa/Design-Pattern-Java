package pay.strategy;

import utils.enums.PayType;

/**
 * 
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