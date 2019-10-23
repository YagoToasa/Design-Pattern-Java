package pay.flow;

import person.Customer;

/**
 * @className: Alipay
 * @author: Wenyue Li
 * @description: 支付宝付款 具体处理者
 * @designPattern:
 * @date: 5:44 下午 2019/10/23
 */
public class Alipay extends CheckOutHandler {

    public Alipay() {
        super("支付宝");
    }

    @Override
    public boolean checkOut(int payment, Customer customer) {
        int balanceInAlipay = customer.getBalanceInAlipay();
        if (payment <= balanceInAlipay) {
            customer.setBalanceInAlipay(balanceInAlipay - payment);
            System.out.printf("顾客[%s]使用[%s]支付了[%d]元\n", customer.getName(), this.handlerName, payment);
            return true;
        } else if (this.nextHandler != null) {
            System.out.printf("[%s]余额不足，尝试使用[%s]支付\n", this.handlerName, this.nextHandler.handlerName);
            this.nextHandler.checkOut(payment, customer);
        } else {
            System.out.println("支付失败! [ERROR]");
        }
        return false;
    }
}