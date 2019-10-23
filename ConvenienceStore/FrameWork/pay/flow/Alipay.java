package pay.flow;

/**
 * 
 */
public class Alipay extends CheckOutHandler {

    /**
     * Default constructor
     */
    @Override
    public void Pay(){
        System.out.print("您已使用Alipay支付！");
    }
    public Alipay() {
    }

}