package decoration.command;

import decoration.Decoration;
import decoration.furniture.Chair;
/**
 * @className: AddChair
 * @author: Siqian Wu
 * @description: 具体命令类，删除Chair命令
 * @designPattern: Command
 * @date: 14:18 2019-10-23
 * @version: v1.0 版本
 */
public class RemoveChair implements Command{
    private Decoration decoration;
    public RemoveChair(Decoration decoration)
    {
        this.decoration=decoration;
    }
    public void exec()
    {
        Chair chair = new Chair();
        decoration.removeFurniture(chair);
    }
}
