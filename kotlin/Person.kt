
data class Person(val name: String ) {

    var age : Int = 20
        set (_age) {
            println("old age=$field")
            field = _age
        }

    val isAdult
        get() = age>=18

}