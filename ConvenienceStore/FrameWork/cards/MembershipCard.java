package cards;

/**
 * @className: MembershipCard
 * @author: Yinan Cheng
 * @description: 抽象类，是OrdinaryMembershipCard和SeniorMembershipCard的父类
 * @designPattern: factory method
 * @date: 20:45 2019/10/23
 */
public abstract class MembershipCard {
    protected String name;
    public abstract void showMemberShipCard();
}
