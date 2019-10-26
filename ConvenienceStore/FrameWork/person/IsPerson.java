package person;

/**
 * @className: NullPerson
 * @author: Kunyu Chen
 * @description:新增的新增的抽象接口IsPerson类
 * @designPattern: Null Object
 * @date: 2019-10-26
 * @version: v1.0 版本
 */

public interface IsPerson {
    /**
     * 判断Person对象是否为空对象
     *
     * @methodName: isNull
     * @param:
     * @return: boolean
     */
    public boolean isNull();
    /**
     * 展示Person对象的信息内容
     *
     * @methodName: showPerson
     * @param:
     * @return: void
     */
    public void showPerson();
}
