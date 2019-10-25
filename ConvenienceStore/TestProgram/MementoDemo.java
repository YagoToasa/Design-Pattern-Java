import store.mementor.Originator;
import store.mementor.DataCareTaker;

public class MementoDemo {

    public static void main(String[] args) {
        //备忘录初始化
        DataCareTaker mMementoCaretaker = new DataCareTaker();
        Originator mOriginator = new Originator();
        System.out.println("START ========================== Memento Demo ==========================");
        //等待调取库存的函数更新后处理成第一个状态，暂用固定数据
        mOriginator.testState1();

        //将当前状态存储到备忘录
        mMementoCaretaker
                .saveMemento("Originator", mOriginator.createMemento());

        //从备忘录里查看当前状态
        mOriginator.showState();

        //第二个状态，库存发生变动后调取当前状态，暂用固定数据
        mOriginator.testState2();

        //展示当前状态
        mOriginator.showState();


        //顾客要退货，此处等待一个允许顾客退货的函数操作



        // 退回之前的状态
        mOriginator.restoreMemento(mMementoCaretaker
                .retrieveMemento("Originator"));

        //展示一下
        mOriginator.showState();
        System.out.println("E N D ========================== Memento Demo ==========================\n");


    }

}



