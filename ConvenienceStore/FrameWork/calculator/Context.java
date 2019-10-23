package calculator;

/**
 * @className: Context
 * @author: Shidan Cheng
 * @description: 上下文
 * @designPattern: Interpreter
 * @date: 9:25 上午 2019/10/23
 * @version: v1.0
 */
public class Context {
    String statement;
    public Context(String statement){
        this.statement = statement;
    }
}
