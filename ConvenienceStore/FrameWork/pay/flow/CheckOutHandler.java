package pay.flow;

/**
 * @className: CheckOutHandler
 * @author: Wenyue Li
 * @description: 支付流程处理者 抽象类
 * @designPattern: Chain of Responsibility
 * @date: 5:36 下午 2019/10/23
 */
public abstract class CheckOutHandler {
    protected CheckOutHandler nextHandler;

    public void setNextHandle(CheckOutHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    // 付款是针对消费者Customer而言的，消费者类似游戏NPC
    // 可以在utils.info.ConstantTable 中添加消费者的一些默认参数
    // 如：现金金额、支付宝余额、微信余额等;
    public abstract boolean checkOut(int payment);
}