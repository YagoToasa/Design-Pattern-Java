package calculator;

import java.util.HashMap;

/**
 * @className: Context
 * @description: 解释器类
 * @author: Liwen Zhu
 * @date: 19:51 2019/10/26
 * @version: v1.0
 */
public class Context {
    public static HashMap<String, Integer> test(){
// 构造运算元素的值列表
        HashMap<String, Integer> ctx = new HashMap<String, Integer>();
        /*------- 蛋黄酥代号: a -------
        * ------- 蛋挞代号: b --------
        * ------- 饼干代号: c --------
        * ------- 饭团代号: d --------
        * ------- 薯片代号: e --------
        * ------- 矿泉水代号: f -------
        * ------- 可乐代号: g --------
        * ------- 巧克力代号: h -------
        * ------- 雪碧代号: i --------
         */
        ctx.put("a", 9);
        ctx.put("b", 5);
        ctx.put("c", 7);
        ctx.put("d", 4);
        ctx.put("e", 8);
        ctx.put("f", 1);
        ctx.put("g", 4);
        ctx.put("h", 10);
        ctx.put("i", 3);
        return ctx;
    }
}
