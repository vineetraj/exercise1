import java.io.FileInputStream

@Throws(InterruptedException::class)
fun divide(a:Int,b:Int):Double{
    Thread.sleep(1000)
    return (a.toDouble()/b)
}

//using use keyword to work like 'try with resources'
fun printFile(){
    val input = FileInputStream("hello.txt")
    input.use {
        //an exception could be thrown here
        // then that object will be automatically closed
    }
}

fun main() {
    //assigning value of try block to a variable
    var result = try {
        divide(5,23)
    }catch (e :Exception){
        println(e)
        0
    }
    println(result)
}