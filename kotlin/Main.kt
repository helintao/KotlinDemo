fun main() {
    println(
        """
        \\
            hello kotlin
            欢迎来到kotlin世界!!!
        \\
    """.trimIndent()
    )

    val a = 10;
    var b = 20;
    println("使用\$a a=$a b=$b,a+b=${sum(a, b)}")

    var person_1 = Person("001")
    val person_2 : Person? = null
    println("person_1 = ${person_1.toString()} \n person_2 =${person_2?.toString()?:"person is null"}")

}

//声明函数
fun sum(a: Int, b: Int): Int = a + b