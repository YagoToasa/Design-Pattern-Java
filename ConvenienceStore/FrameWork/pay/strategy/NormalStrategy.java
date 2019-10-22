package pay.strategy;

import pay.flow.Alipay;
import pay.flow.Cash;
import pay.flow.WeChat;
import utils.enums.PayType;

/**
 * 
 */
public class NormalStrategy extends Strategy {
    @Override
    public void solve(float amount, PayType type){
        if(type==PayType.Alipay){
            System.out.print("您的付款金额为："+amount+"您的付款方式为:Alipay");
            Alipay payment=new Alipay();
            payment.Pay();
        }
        if(type==PayType.WeChat){
            System.out.print("您的付款金额为："+amount+"您的付款方式为:Wechat");
            WeChat payment=new WeChat();
            payment.Pay();
        }
        if(type==PayType.Cash){
            System.out.print("您的付款金额为："+amount+"您的付款方式为:Cash");
            Cash payment=new Cash();
            payment.Pay();
        }
    }
    /**
     * Default constructor
     */
    public NormalStrategy() {
    }


}