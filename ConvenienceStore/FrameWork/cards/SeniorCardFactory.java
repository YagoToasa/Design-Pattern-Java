package cards;

/**
 * @className: SeniorCardFactory
 * @author: Yinan Cheng
 * @description:
 * @designPattern:
 * @date: 21:16 2019/10/23
 */
public class SeniorCardFactory implements CardFactory {
    @Override
    public MembershipCard getCard(String name) {
        System.out.println("高级会员卡工厂正在制作卡片！");
        return new SeniorMembershipCard(name);
    }
}
