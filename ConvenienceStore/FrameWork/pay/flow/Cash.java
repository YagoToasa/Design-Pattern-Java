package pay.flow;

/**
 * 
 */
public class Cash extends CheckOutHandler {
    @Override
    public void Pay(){
        System.out.print("您已使用Cash支付！");
    }
    /**
     * Default constructor
     */
    public Cash() {
    }

}