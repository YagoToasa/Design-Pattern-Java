package pay.strategy;

import utils.info.ConstantTable;

/**
 * @className: PremiumMemberStrategy
 * @author: Wenyue Li
 * @description: 高级会员支付策略
 * @designPattern: Strategy
 * @date: 7:42 下午 2019/10/23
 * @version: v1.0
 */
public class PremiumMemberStrategy extends Strategy {

    public PremiumMemberStrategy() {
        super(ConstantTable.PREMIUM_MEMBER_DISCOUNT);
    }

}
