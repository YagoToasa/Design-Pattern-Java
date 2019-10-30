package person;
/**
 * @className: NullPerson
 * @author: Kunyu Chen
 * @description:新增的空对象类NullPerson类的代码（继承IsPerson类)
 * @designPattern: Null Object
 * @date: 2019-10-26
 * @version: v2.0 版本
 */

public class NullPerson implements IsPerson {

    public boolean isNull() {
        return true;
    }

    public void showPerson() {
        System.out.println("| 身份不符，拒绝进入。");
    }
}
