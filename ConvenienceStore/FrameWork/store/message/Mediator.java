package store.message;
/**
 * @className: 类名
 * @author: 作者
 * @description: 描述
 * @designPattern: 模式
 * @date: 日期
 * @version: v1.0 版本
 */
import person.Person;

public interface Mediator {
    public abstract void register(String personName, Person person);

    public abstract void getMessage(String message, String personName);
}