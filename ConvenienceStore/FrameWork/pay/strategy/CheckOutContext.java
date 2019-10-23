package pay.strategy;

import pay.flow.CheckOutHandler;

/**
 * @className: CheckOutContext
 * @author: Wenyue Li
 * @description: 付款上下文
 * @designPattern: Strategy
 * @date: 7:20 下午 2019/10/23
 */
public class CheckOutContext {
    private Strategy strategy;                      //优惠策略

    /**
     * 默认构造函数
     *
     * @methodName: CheckOutContext
     */
    public CheckOutContext() {
        this.strategy = null;
    }

    /**
     * 指定优惠策略的构造函数
     *
     * @methodName: CheckOutContext
     * @param strategy: Strategy 优惠策略
     */
    public CheckOutContext(Strategy strategy) {
        this.strategy = strategy;
    }


    /**
     * 获取顾客应支付的金额, 若未指定优惠策略，则返回原总开销
     *
     * @methodName: getTotalCost
     * @param originalTotalCost: 原总开销
     * @return: int
     */
    public int getTotalCost(int originalTotalCost) {
        if (this.strategy == null) {
            return originalTotalCost;
        }
        return strategy.getPayment(originalTotalCost);
    }

    /**
     * 设定优惠策略
     *
     * @methodName: setStrategy
     * @param strategy: Strategy 优惠策略
     * @return: void
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

}