# Design-Pattern-Java

![](https://img.shields.io/badge/Language-Java-green)	![](https://img.shields.io/badge/Number%20of%20team-9-orange)  ![](https://img.shields.io/github/last-commit/YagoToasa/Design-Pattern-Java)
## 结构说明：
- FrameWork: 游戏的依赖框架
- TestProgream: 基于设计模式的应用, 分别展示30个设计模式, 请运行Application.java
- GameProgram: 基于游戏流程的应用, 请运行GameApplication.java
- 请将FrameWork及TestProgram设置为SourceRoot



## 分支命名规范
- 李小明 学号: 123456
- 123456_XiaomingLi



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
### Creational patterns

- [x] Abstract Factory
- [x] Builder
- [x] Factory Method
- [x] Object Pool
- [x] Prototype
- [x] Singleton

### Structural patterns

- [x] Adapter
- [x] Bridge
- [x] Composite
- [x] Decorator
- [x] Facade
- [x] Flyweight
- [x] Private Class Data
- [x] Proxy

### Behavioral patterns

- [x] Chain Of Responsibility
- [x] Command
- [x] Interpreter
- [x] Iterator
- [x] Mediator
- [x] Memento
- [x] Null Object
- [x] Observer
- [x] State
- [x] Strategy
- [x] Template Method
- [x] Visitor

### Unknown patterns

- [x] Filter 
- [x] Composite Entity 
- [x] Specification 
- [x] Double Click Checking 
