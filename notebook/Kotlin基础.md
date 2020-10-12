# Kotlin

## 函数
```kotlin
fun sum (a : Int, b : Int) : Int {
    return a + b;
}
```
- fun 声明函数关键字

## 语句和表达式
在Kotlin中，if是表达式不是语句。除了循环（for/whlie和do/while)外大多数控制结构都是表达式。

- 表达式函数体
```kotlin
fun sum (a : Int, b : Int) : Int = a + b
```

- 类型推导

编译器会分析作为函数体的表达式，把它的类型作为函数的返回类型.上述表达式可以省掉返回类型：
```kotlin
fun sum (a : Int, b : Int) = a + b
```

## 变量

- val：不可变引用。不能在初始化之后再次赋值。对应java的final变量

- var：可变引用。值可变。对应java非final变量

## 字符串模板

符号：$

格式: 
- $变量名
- ${表达式}

```kotlin
fun main(){
    val name = "kotlin"
    println("Hello,$name!")
    println("10+20=${10+20}")
}

>>> Hello,kotlin!
```

## 类和属性

```kotlin
class Person(val name : String, var age : Int)
```

### 属性

val:只读属性（一个getter)

var:可写属性(一个getter,一个setter)

访问：
```kotlin
val person = Person("banana","23")
person.age = 24 //调用setter
println(preson.name) //调用getter
```

### 自定义访问器
```kotlin
class Person(val name : String, var age : Int){
    val isAdult
        get() = age>=18
}
```

## 枚举和when

### 声明枚举

- 关键字：enum class
```kotlin
enum class Color{
    RED,ORANGE,YELLOW,GREEN,BLUE,INDIGO,VIOLET
}

//带属性的枚举类
enum class Color(val r : Int, val g : Int, val b : Int){
    RED(255,0,0),
    ORANGE(255,165,0),
    YELLOW(255,255,0)；//kotlin唯一一处必须使用分号的地方。

    fun rgb() = (r * 256 + g) * 256 + b
}
```

### when
一个有返回值的表达式。对于java的switch，但比switch更强大
- 处理枚举
```kotlin
fun getColor(color : Color) = 
    when (color) {
        Color.RED -> "red"
        Color.ORANGE -> "orange"
        Color.YELLOW ->"yellow"
    }

//合并多个选项
fun getColor(color : Color) = 
    when (color) {
        Color.RED，Color.ORANGE，Color.YELLOW -> "color"
    }
```

不需要在分支写上break语句，可以避免遗漏break导致bug。

- 使用任意对象
```kotlin
fun mix(c1:Color,c2:Color) =
    when (setOf(c1,c2)){
        setOf(RED,YELLOW) -> ORANGE
        setOf(YELLOW,BLUE) -> GREEN
        else -> throw Execption("Dirty color") //如果没有分支匹配，执行。
    }
```
上述使用的是set来比较，set不区分顺序，即set(RED,YELLOW)和set(YELLOW,RED)结果相同。

- 不带参数
 
    上面代码，严重影响效率，每次比较都要创建一个set。重写（但可读性差）
 ```kotlin
 fun mix(c1:Color,c2:Color) =
    when {
        (c1 == RED && C2 == YELLOW)||
        (C1 == YELLOW && C2 == RED) -> ORANGE

        (c1 == YELLOW && C2 == BLUE)||
        (C1 == BLUE && C2 == YELLOW) -> GREEN

        else -> throw Execption("Dirty color")

    }
 ```

 ## 继承与实现、判断类型、转换类型
 - 继承与实现

    关键字: **:**
 ```kotlin

 class Button() : View()

 interface Expr
 class Num(val value : Int) : Exper
 ```

 - 判断类型

    关键字: is

    类似于java中instaneOf。但使用is的同时变量会被智能转换，不需要显示转换。

 - 类型转换

    关键字：as

    显示转换类型

```kotlin
fun eval (e : Expr) : Int {
    if(e is Num) {
        val n = e as Num //多余的转换
        return n.value
    }
}
```

## 循环

- while和do..while
    
    语法和java相同

- 区间和数列

    区间运算符（闭合）： ..

    能迭代区间中所以值，这样的区间称之为数列

```kotlin
    //输出1到10
    for(i in 1..10){
        print("$i ")
    }

    //从10开始递减到1，步长为2即-2
    for(i in 10 downTo 1 step 2){
        println("$i ")
    }

    //迭代map
    for((key,value) in map){
        //迭代map，把键值赋给变量key,value
        println("key=$key,value=$value")
    }

    //迭代list,其中withIndex是集合的一个扩展函数
    for((index,element) in list.withIndex()){
        println("index=$index,element=$element")
    }
```
上面代码中downTo表示递减，step表示步长

- 检测集合和区间成员

    关键字：in、逆运算：!in

    in、!in运算符也适用于when分支

```kotlin
    //检查集合是否包含”kotlin"
    prinltn("kotlin" in setOf("java","kotlin"))
>>> true
```

## kotlin异常

    kotlin异常处理和java类似，kotlin中throw、try..catch..finally是表达式。

    kotlin不用显示抛出异常，并且可以处理或不处理异常。（为了减少代码的冗余）

