fun main(args: Array<String>) {
    val colors = listOf("RED", "GREEN", "BLUE") //immutable list
    println(colors::class.qualifiedName)

    val month = mutableListOf("Jan", "Feb", "Dec")
    println(month)

    val days = mutableListOf<Int>() //valid if we give the data type & don't give initial values
    println(days)

    val myMap = mapOf("Red" to "cyan", "blue" to "green")

    val arr : Array<Int> = arrayOf(0,1,2)
    val intArr : IntArray = intArrayOf(1,2,3,4,5)
    intArr.set(2,-10) //replace value at given position
    intArr[0]=-11 //same operation as above
    intArr.forEach { println(it) }

    println(colors[1])
}
