package TestProgramDemo;

import TestProgramDemo.PatternRealizationDemo.BridgeDemo;
import TestProgramDemo.PatternRealizationDemo.BuilderDemo;
import TestProgramDemo.PatternRealizationDemo.ProxyDemo;
import TestProgramDemo.PatternRealizationDemo.CompositeDemo;
import TestProgramDemo.PatternRealizationDemo.NullObjectDemo;
import TestProgramDemo.PatternRealizationDemo.TemplateMethodDemo;
import TestProgramDemo.PatternRealizationDemo.StrategyDemo;
import TestProgramDemo.PatternRealizationDemo.ChainOfResponsibilityDemo;

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

    public static void main(String[] args) {
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

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    TemplateMethodDemo.main(args);
                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "9":

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

                    break;
                case "14":

                    break;
                case "15":
                    PrototypeDemo.main(args);
                    break;
                case "16":

                    break;
                case "17":
                    NullObjectDemo.main(args);
                    break;
                case "18":
                    CompositeDemo.main(args);
                    break;
                case "19":

                    break;
                case "20":

                    break;
                case "21":

                    break;
                case "22":
                    ProxyDemo.main(args);
                    break;
                case "23":
                    ChainOfResponsibilityDemo.main(args);
                    break;
                case "24":

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
