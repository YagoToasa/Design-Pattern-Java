package cards;

/**
 * @className: OrdinaryCardFactory
 * @author: Yinan Cheng
 * @description:
 * @designPattern:
 * @date: 19:19 2019/10/23
 */
public class OrdinaryCardFactory implements CardFactory {

    @Override
    public MembershipCard getCard(String name) {
        System.out.println("普通会员卡工厂正在制作卡片！");
        return new OrdinaryMembershipCard(name);
    }
}
