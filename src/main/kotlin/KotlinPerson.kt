import java.util.Calendar
import java.util.GregorianCalendar

data class KotlinPerson(
    val id: Long,
    val title: String,
    val firstName: String,
    val surname: String,
    val dateOfBirth: Calendar?
) {

    override fun toString() = "$title $firstName $surname"

    companion object {
        fun getAge(dateOfBirth: Calendar?): Int? {
            if (dateOfBirth == null) return null
            val today: Calendar = GregorianCalendar()
            val years: Int = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
            return if (dateOfBirth.get(Calendar.DAY_OF_YEAR) >= today.get(Calendar.YEAR)) years - 1 else years
        }
    }

    fun getLastLetter(a: String): String = a.takeLast(1)

    var favColor: String? = null //mutable property

    fun getUpperCaseColor(): String {
//        return if(favColor == null) "" else favColor.uppercase() => error
        return favColor?.uppercase() ?: ""
    }

    fun getLastLetterFavColor(): String {
//       return if (favColor == null) "" else getLastLetter(favColor)
        return favColor?.let { getLastLetter(it) } ?:""
    }

    fun getColorType():String{
        val color= getUpperCaseColor()
        return when(color){
            "" -> "Empty"
            "Red","Green","Blue"->"RGB"
            else -> "Other"
        }
    }

    val safeAge: Int
        get() = age ?: -1 // elvis operator

    /* method 2
    return if (age != null) {
         age!!
     }
     else -1
     */

    /* method 3
    val localAge = age
    return if (localAge!=null)
        localAge
    else -1
    */

    val age: Int?
        get() = getAge(dateOfBirth)
}

fun main(args: Array<String>) {
    val john = KotlinPerson(1L, "Mr", "John", "Blue", GregorianCalendar(1977, 9, 3))
    val jane = KotlinPerson(2L, "Mrs", "Jane", "Green", null)
    println("john's age is ${john.age}")
    println("jane's age is ${jane.age}")
    println("The age of someone born on 3rd May 1988 is " + KotlinPerson.getAge(GregorianCalendar(1988, 5, 3)))
    val olderPerson = if (john.safeAge > jane.safeAge) john else jane
    println("The older person is $olderPerson")
    println("jane's fav color is ${jane.getLastLetterFavColor()}")
}
