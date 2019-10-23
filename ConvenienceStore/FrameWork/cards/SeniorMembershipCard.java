package cards;

import utils.info.PriceTable;

/**
 * @className: SeniorMembershipCard
 * @author: Yinan Cheng
 * @description:
 * @designPattern:
 * @date: 21:17 2019/10/23
 */
public class SeniorMembershipCard extends MembershipCard {
    protected SeniorMembershipCard(String name){
        this.name=name;
    }
    @Override
    public void createMembershipCard() {
        System.out.println("高级会员卡创建成功啦！");
        System.out.println("持卡者姓名："+this.name);
        System.out.println("此卡的价格为"+ PriceTable.SENIOR_CARD);
    }
}
