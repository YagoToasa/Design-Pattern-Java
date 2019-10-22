package person;

import utils.enums.PersonType;

/**
 * @className: Person
 * @description:人物的基类
 * @author: Wenyue Li
 * @date: 8:42 下午 2019/10/21
 * @version: v1.0
 */
public abstract class Person {

    protected String name;      //人物名称
    protected PersonType type;  //人物类型，eg：顾客、店主、店员
    /**
     * Default constructor
     */
    public Person() {
    }

    public PersonType getType(){
        return type;
    }

    protected void setType(PersonType type){
        this.type=type;
    }

    public String getName(){
        return name;
    }

    protected void setName(String name){
        this.name=name;
    }

}