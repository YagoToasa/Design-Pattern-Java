package pay.strategy;

import utils.info.ConstantTable;

/**
 * @className: OrdinaryMemberStrategy
 * @author: Wenyue Li
 * @description: 普通会员支付策略
 * @designPattern: Strategy
 * @date: 7:41 下午 2019/10/23
 * @version: v1.0
 */
public class OrdinaryMemberStrategy extends Strategy {
    public OrdinaryMemberStrategy() {
        super(ConstantTable.ORDINARY_MEMBER_DISCOUNT);
    }
}
