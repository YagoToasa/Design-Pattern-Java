package TestProgramDemo;

import TestProgramDemo.PatternRealizationDemo.*;

import java.util.Scanner;

public class application {
    private static Scanner scanner = new Scanner(System.in);
    private static String symbol = "";

    public static void welcome() {
        System.out.println("*-=======================   USAGE INFO   =============================-*");
        System.out.println("|                      [d]  Directory                                  |");
        System.out.println("|                      [q]  Exit                                       |");
        System.out.println("*-====================================================================-*");
    }

    public static void showDirectory() {
        System.out.println("*-=======================   Design Patterns  =========================-*");
        System.out.println("|                      [d]  Directory                                  |");
        System.out.println("|                      [q]  Exit                                       |");
        System.out.println("|                      [1]  Singleton                                  |");
        System.out.println("|                      [2]  AbstractFactory                            |");
        System.out.println("|                      [3]  Factory Method                             |");
        System.out.println("|                      [4]  Template Method                            |");
        System.out.println("|                      [5]  Observer                                   |");
        System.out.println("|                      [6]  Iterator                                   |");
        System.out.println("|                      [7]  State                                      |");
        System.out.println("|                      [8]  Command                                    |");
        System.out.println("|                      [9]  Decorator                                  |");
        System.out.println("|                     [10]  Strategy                                   |");
        System.out.println("|                     [11]  Builder                                    |");
        System.out.println("|                     [12]  Bridge                                     |");
        System.out.println("|                     [13]  Facade                                     |");
        System.out.println("|                     [14]  Flyweight                                  |");
        System.out.println("|                     [15]  Prototype                                  |");
        System.out.println("|                     [16]  Memento                                    |");
        System.out.println("|                     [17]  Null Object                                |");
        System.out.println("|                     [18]  Composite                                  |");
        System.out.println("|                     [19]  Visitor                                    |");
        System.out.println("|                     [20]  Adaptor                                    |");
        System.out.println("|                     [21]  Mediator                                   |");
        System.out.println("|                     [22]  Proxy                                      |");
        System.out.println("|                     [23]  Chain Of Responsibility                    |");
        System.out.println("|                     [24]  Interpreter                                |");
        System.out.println("*-====================================================================-*");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        welcome();
        System.out.printf("> 请输入指令: ");
        if (scanner.hasNext()) {
            symbol = scanner.next();
        }
        while (!symbol.equals("q")) {
            switch (symbol) {
                case "d":
                    showDirectory();
                    break;
                case "q":
                    System.exit(0);
                    break;
                case "1":
                    SingletonDemo.main(args);
                    break;
                case "2":
                    AbstractFactoryDemo.main(args);
                    break;
                case "3":
                    FactoryMethodDemo.main(args);
                    break;
                case "4":
                    TemplateMethodDemo.main(args);
                    break;
                case "5":
                    ObserverDemo.main(args);
                    break;
                case "6":
                    IteratorDemo.main(args);
                    break;
                case "7":
                    StateDemo.main(args);
                    break;
                case "8":
                    CommandDemo.main(args);
                    break;
                case "9":
                    DecoratorDemo.main(args);
                    break;
                case "10":
                    StrategyDemo.main(args);
                    break;
                case "11":
                    BuilderDemo.main(args);
                    break;
                case "12":
                    BridgeDemo.main(args);
                    break;
                case "13":
                    AdapterWithFacadeDemo.main(args);
                    break;
                case "14":
                    FlyweightDemo.main(args);
                    break;
                case "15":
                    PrototypeDemo.main(args);
                    break;
                case "16":
                    MementoDemo.main(args);
                    break;
                case "17":
                    NullObjectDemo.main(args);
                    break;
                case "18":
                    CompositeDemo.main(args);
                    break;
                case "19":
                    VisitorDemo.main(args);
                    break;
                case "20":
                    AdapterWithFacadeDemo.main(args);
                    break;
                case "21":
                    MediatorDemo.main(args);
                    break;
                case "22":
                    ProxyDemo.main(args);
                    break;
                case "23":
                    ChainOfResponsibilityDemo.main(args);
                    break;
                case "24":
                    InterpreterDemo.main(args);
                    break;
                default:
                    System.out.println("> [ERROR] 指令不存在!");
            }
            System.out.printf("> 请输入指令: ");
            if (scanner.hasNext()) {
                symbol = scanner.next();
            }
        }
    }
}
