package pay.flow;
/**
 * @className: Cash
 * @author: Wenyue Li
 * @description: 现金支付 具体处理者
 * @designPattern: Chain of Responsibility
 * @date: 5:43 下午 2019/10/23
 */
public class Cash extends CheckOutHandler {

    public Cash(){

    }

    @Override
    public boolean checkOut(int payment) {
        return false;
    }



}