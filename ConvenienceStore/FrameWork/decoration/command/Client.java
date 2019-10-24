package decoration.command;

import decoration.Decoration;

/**
 * @className: Client
 * @author: Siqian Wu
 * @description: 创建具体的命令对象，并且设置命令对象的接收者。
 * @designPattern: Command
 * @date: 00:56 2019-10-24
 * @version: v1.0 版本
 */
public class Client {
    private Invoker invoker=Invoker.getInvoker();
    private Command RemoveChair=new RemoveChair(Decoration.getDecoration()),
                    AddDesk=new AddDesk(Decoration.getDecoration()),
                    RemoveDesk=new RemoveDesk(Decoration.getDecoration()),
                    AddChair=new AddChair(Decoration.getDecoration());

    public Client() {
    }

    public void addChair()
    {
        invoker.setCommand(AddChair);
        invoker.runCommand();
    }

    public void addDesk()
    {
        invoker.setCommand(AddDesk);
        invoker.runCommand();
    }

    public void rmvChair()
    {
        invoker.setCommand(RemoveChair);
        invoker.runCommand();
    }

    public void rmvDesk()
    {
        invoker.setCommand(RemoveDesk);
        invoker.runCommand();
    }
}
