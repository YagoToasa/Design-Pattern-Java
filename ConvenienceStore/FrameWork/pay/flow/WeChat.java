package pay.flow;

/**
 * 
 */
public class WeChat extends CheckOutHandler {
    @Override
    public void Pay(){
        System.out.print("您已使用WeChat支付！");
    }
    /**
     * Default constructor
     */
    public WeChat() {
    }

}