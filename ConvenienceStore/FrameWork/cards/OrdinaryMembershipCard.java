package cards;

import utils.info.PriceTable;

/**
 * @className: OrdinaryMembershipCard
 * @author: Yinan Cheng
 * @description: 生成普通会员卡
 * @designPattern: factory method
 * @date: 19:19 2019/10/23
 */
public class OrdinaryMembershipCard extends MembershipCard {
    protected OrdinaryMembershipCard(String name){
        this.name=name;
    }

    @Override
    public void createMembershipCard() {
        System.out.println("普通会员卡创建成功啦！");
        System.out.println("持卡者姓名："+this.name);
        System.out.println("此卡的价格为"+ PriceTable.ORDINARY_CARD);
    }
}
