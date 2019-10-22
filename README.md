# Design-Pattern-Java

![](https://img.shields.io/badge/Language-Java-green)	![](https://img.shields.io/badge/Number%20of%20team-10-orange)  ![](https://img.shields.io/github/last-commit/YagoToasa/Design-Pattern-Java)
## 代码规范
- 类名: UpperCamelCase
- 方法名: lowerCamelCase
- 常量: CONSTANT_CASE
- 非常量: lowerCamelCase
- 参数: lowerCamelCase
- 局部变量: lowerCamelCase
- `@Override`: 合法则标注
- 变量声明: 不允许组合声明
- 代码格式化: IDEA格式
- `if, else, for, do, while`: 必须加`{}`
- 注释: 必须包含作者


## 注释说明
1. 类注释
```java
    /**
     * @className: 类名
     * @author: 作者
     * @description: 描述
     * @designPattern: 模式
     * @date: 日期
     * @version: v1.0 版本
     */
```
2. 方法注释
- 默认方法的作者与所属类的作者一致
```java
    /**
     * 描述
     * 
     * @methodName: 方法名
     * @param: 参数
     * @return: 返回类型
     */
```
- 方法的作者与所属类的作者不一致
```java
    /**
     * 
     * 
     * @methodName:
     * @author:
     * @date:  
     * @param: 
     * @return: 
     */
```
- 当你修改了他人写的方法
```java
   /** @update: 修改描述 - 姓名 */
```


## 30种设计模式
**只有完成了相应的Demo才算完成，Demo请放在TestProgram文件夹下，输出格式参见`BuilderDemo.java`**

### Creational patterns

- [ ] Abstract Factory
- [x] Builder
- [ ] Factory Method
- [ ] Object Pool
- [x] Prototype
- [ ] Singleton

### Structural patterns

- [ ] Adapter
- [x] Bridge
- [ ] Composite
- [x] Decorator
- [ ] Facade
- [ ] Flyweight
- [ ] Private Class Data
- [x] Proxy

### Behavioral patterns

- [ ] Chain Of Responsibility
- [ ] Command
- [ ] Interpreter
- [x] Iterator
- [ ] Mediator
- [ ] Memento
- [ ] Null Object
- [ ] Observer
- [x] State
- [ ] Strategy
- [ ] Template Method
- [ ] Visitor

### Unknown patterns

- [ ] Filter 
- [ ] Composite Entity 
- [ ] Specification 
- [ ] Double Click Checking 
