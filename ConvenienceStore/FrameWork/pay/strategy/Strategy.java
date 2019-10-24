package pay.strategy;


/**
 * @className: Strategy
 * @author: Wenyue Li
 * @description: 策略 抽象类
 * @designPattern: Strategy
 * @date: 5:48 下午 2019/10/23
 */
public abstract class Strategy {
    protected float discount;

    public Strategy(float discount) {
        this.discount = discount;
    }

    /**
     * 获取顾客应付的金额
     *
     * @methodName: getPayment
     * @param originalTotalCost: int 初始总金额
     * @return: int
     */
    public int getPayment(int originalTotalCost){
        return (int)(originalTotalCost * this.discount);
    }

    /**
     * 获取优惠比率——仅为测试输出模型而设置
     *
     * @methodName: getDiscount
     * @return: float
     */
    public float getDiscount() {
        return discount;
    }
}