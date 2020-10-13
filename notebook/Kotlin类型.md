# 可空与不可空变量
声明
```kotlin
    val gender : String? = null
    val _gender:String = "null"
```
可空类型不能赋值给非空类型

## 安全调用符

符号 ：?.
```kotlin
    val person_5:Person? = null
    println(person_5?.name)

    //等价于
    if(null != person_5){
        return person_5.name
    }else{
        return null
    }
```

## Elvis运算符：?:
Elvis运算符接收两个运算数，如果第一个运算数不为null ，运算结果就是第一个运算数；如果第一个运算数为null，运算结果就是第二个运算数。
```kotlin
//如果s为null返回null，否则返回s
fun foo(s:String?){
    return t : String = s ?: ""
}
//与?.合用
val person_5:Person? = null
println(person_5?.name?:"person is null")
```

## 安全转换：as?
as?运算符尝试把值转换成指定的类型，如果值不是合适的类型就返回null

## 非空断言：!!
如果为null抛出异常
```kotlin
    val person_5:Person? = null
    person_5!!.name
>>> Exception in thread "main" java.lang.NullPointerException
	 at MainKt.main(Main.kt:65)
	 at MainKt.main(Main.kt)
```

# 数据类型
## 基本数据类型
- 整数类型：Byte,Short,Int,Long
- 浮点数类型：Float,Double
- 字符类型：Char
- 布尔类型：Boolean

## 可空的基本数据类型
编译为Java的对应的包装类型变量如Integer，因为值可null

# Any和Any?：根类型
和Object作为Java类的层级结构的根差不多。Any是所有非空类型的根，Any?是所有可空类型的根。使用Any时，编译器会编译成java.lang.Object类型

# Unit类型：Kotlin的"void"
Kotlin中的Unit类型完成了Java中的void一样的功能。

# 集合与数组
```kotlin
    //创建包含可空Int值的列表
    val result = ArrayList<Int?>()
```
List<Int?>:列表本身不为null,列表中的值可为null
List<Int>?:列表本身可为null,列表中的值不为null

## 只读集合和可变集合
- 使用kotlin.collections.Collection接口可以遍历集合中的元素、获取集合大小、判断集合中是否包含某个元素，以及执行其他从该集合中读取数据的操作。但这个接口没有任何添加或移除元素的方法
- 使用kotlin.collections.MutableCollection接口可以修改集合中的数据它继承了普通的kotlin.collections.Collection接口
```kotlin
    //只读集合接口
    val source : Collection<Int> = arrayListOf(1,3,5,7,9)
    //可变集合接口
    val target : MutableCollection<Int> = arrayListOf(2,4,6,8,10)
```
|类型|只读|可变|
|-|-|-|
|List|listOf|mutableListOf,arrayListOf|
|Set|setOf|mutableSetOf,hashSetOf,linkedSetOf,sortedSetOf|
|Map|mapOf|mutableMapOf,hashMapOf,linkedMapOf,sortedMapOf|

## 对象和基本数据类型数组
### 对象类型数组
- arrayOf：创建一个数组
- arrayOfNulls:创建一个给定大小的数组，包含null
- Array构造方法接受数组的大小和一个lambda表达式。
```kotlin
    val strings = arrayOf("001", "002")
    val letters = Array<String>(26) { i -> ('a' + i).toString() }
    println(letters.joinToString())
```

### 基本数据类型数组：
如：IntArray,ByteArray,CharArray,BooleanArray等。