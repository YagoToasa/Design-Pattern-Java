package pay.strategy;

import utils.enums.PayType;

/**
 * 
 */
public class CheckOutContext {

    private Strategy strategy;
    private float amount;
    private PayType type;
    /**
     * Default constructor
     */
    public CheckOutContext(float amount,int strategyType,PayType payType) {
        this.amount=amount;
        this.type=payType;
        if(strategyType==0){
            this.strategy=new NormalStrategy();
        }
        else{
            this.strategy=new VIPStrategy();
        }
        System.out.print("您的账单金额为："+this.amount);
        this.strategy.solve(this.amount,this.type);

    }


}