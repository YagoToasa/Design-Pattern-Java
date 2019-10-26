package person;

/**
 * @className: NullPerson
 * @author: Kunyu Chen
 * @description:新增的空对象类NullPerson类的代码（继承IsPerson类)
 * @designPattern: Null Object
 * @date: 2019-10-26
 * @version: v1.0 版本
 */

public class NullPerson implements IsPerson{

    public boolean isNull() {
        return true;
    }

    public void showPerson() {
        System.out.println("Sorry，您输入的信息有误，请确认您输入的不是非法值。");
    }
}
