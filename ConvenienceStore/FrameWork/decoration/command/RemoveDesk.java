package decoration.command;

import decoration.Decoration;
import decoration.furniture.Desk;

/**
 * @className: AddChair
 * @author: Siqian Wu
 * @description: 具体命令类，删除Desk命令
 * @designPattern: Command
 * @date: 14:18 2019-10-23
 * @version: v1.0 版本
 */
public class RemoveDesk implements Command {
    private Decoration decoration;
    public RemoveDesk(Decoration decoration)
    {
        this.decoration=decoration;
    }
    public void exec()
    {
        Desk desk = new Desk();
        decoration.removeFurniture(desk);
    }
}
