package person;

import utils.enums.PersonType;
import person.*;

/**
 * @className: NullPerson
 * @author: Kunyu Chen
 * @description:工厂类,当name或type属于非法值时，返回NullPerson对象。
 * @designPattern: Null Object
 * @date: 2019-10-26
 * @version: v1.0 版本
 */

public class PersonFactory {

    /**
     * 如果name或type是非法值，则返回NullPerson对象，如果二者都合法，根据其type返回对应的对象。
     *
     * @methodName: getPerson
     * @param: String name,String type
     * @return: IsPerson
     */
    public IsPerson getPerson(String name,String type) {

        IsPerson person=null;

        if(name!=null&&type!=null){
            switch(type){
                case "Customer":
                    person=new Customer(name);
                    break;
               /* case "ShopKeeper":
                    person=new ShopKeeper();
                    break;*/
                case "ShopAssistant":
                    person=new ShopAssistant(name);
                    break;
                default:
                    person=new NullPerson();
                    break;
            }
        }
        else{
            person=new NullPerson();
        }
        return person;
    }
}
