package cards;

/**
 * @className: CardFactory
 * @author: Yinan Cheng
 * @description: 会员卡工厂的接口，OrdinaryCardFactory和SeniorCardFactory分别实现了这一接口
 * @designPattern: factory method
 * @date: 20:45 2019/10/23
 */
public interface CardFactory {
    MembershipCard getCard(String name);

}
