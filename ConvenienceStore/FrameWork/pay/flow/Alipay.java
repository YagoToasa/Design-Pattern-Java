package pay.flow;
/**
 * @className: Alipay
 * @author: Wenyue Li
 * @description: 支付宝付款 具体处理者
 * @designPattern:
 * @date: 5:44 下午 2019/10/23
 */
public class Alipay extends CheckOutHandler {

    public Alipay(){

    }

    @Override
    public boolean checkOut(int payment) {
        return false;
    }
}