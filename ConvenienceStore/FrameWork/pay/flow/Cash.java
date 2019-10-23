package pay.flow;

import person.Customer;

/**
 * @className: Cash
 * @author: Wenyue Li
 * @description: 现金支付 具体处理者
 * @designPattern: Chain of Responsibility
 * @date: 5:43 下午 2019/10/23
 */
public class Cash extends CheckOutHandler {

    public Cash() {
        super("现金");
    }

    @Override
    public boolean checkOut(int payment, Customer customer) {
        int cash = customer.getCash();
        if (payment <= cash) {
            customer.setCash(cash - payment);
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