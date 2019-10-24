package decoration.command;

import decoration.Decoration;

/**
 * @className: Invoker
 * @author: Siqian Wu
 * @description: command的执行者
 * @designPattern: Command
 * @date: 14:20 2019-10-23
 * @version: v1.0 版本
 */
public class Invoker {
    private Command command=null;
    static Invoker invoker = new Invoker();

    public static Invoker getInvoker() {
        return invoker;
    }
    public void setCommand(Command command)
    {
        this.command = command;
    }
    public void runCommand()
    {
        command.exec();
        Decoration.getDecoration().showFurniture();
    }
}
