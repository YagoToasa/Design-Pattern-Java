import pay.flow.Alipay;
import pay.flow.Cash;
import pay.flow.CheckOutHandler;
import pay.flow.WeChat;
import person.Customer;

/**
 * @className: ChainOfResponsibilityDemo
 * @author: Shidan Cheng
 * @description: Chain of Responsibility 责任链模式 测试程序
 * @date: 8:32 下午 2019/10/23
 * @version: v1.0
 */
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        System.out.println("START ================== Chain of Responsibility Demo ==================");
        CheckOutHandler cash = new Cash();
        CheckOutHandler alipay = new Alipay();
        CheckOutHandler wechat = new WeChat();
        int payment = 88;
        Customer customer1 = new Customer("小明");
        Customer customer2 = new Customer("小红");
        Customer customer3 = new Customer("小刚");
        System.out.println("> 展示顾客基本财务信息");
        customer1.printBalanceInfo();
        customer2.printBalanceInfo();
        customer3.printBalanceInfo();
        System.out.println("> 展示顾客基本财务信息 [Completed]\n");

        System.out.println("> 假设: 小明消费了88元, 且其付款顺序为: 余额->支付宝->微信");
        cash.setNextHandle(alipay);
        alipay.setNextHandle(wechat);
        cash.checkOut(payment,customer1);
        System.out.println("---");
        System.out.println("> 假设: 小红消费了88元, 且其付款顺序为: 支付宝->微信->余额");
        alipay.setNextHandle(wechat);
        wechat.setNextHandle(cash);
        cash.setNextHandle(null);
        alipay.checkOut(payment,customer2);
        System.out.println("---");
        System.out.println("> 假设: 小刚消费了200元, 且其付款顺序为: 微信->余额->支付宝");
        wechat.setNextHandle(cash);
        cash.setNextHandle(alipay);
        alipay.setNextHandle(null);
        wechat.checkOut(200,customer3);
        System.out.println("E N D ================== Chain of Responsibility Demo ==================\n");
    }
}
