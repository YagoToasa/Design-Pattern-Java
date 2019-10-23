package pay.flow;

/**
 * @className: WeChat
 * @author: Wenyue Li
 * @description: 微信支付 具体处理者
 * @designPattern: Chain of Responsibility
 * @date: 5:44 下午 2019/10/23
 */
public class WeChat extends CheckOutHandler {
    public WeChat() {
    }

    @Override
    public boolean checkOut(int payment) {
        return false;
    }
}