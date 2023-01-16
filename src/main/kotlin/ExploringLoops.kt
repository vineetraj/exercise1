fun main(args: Array<String>) {
    val people = ArrayList<KotlinPerson>()
    people.add(KotlinPerson(1, "Mr", "Waris", "Alam", null))
    people.add(KotlinPerson(2, "Mr", "Vikash", "Singh", null))
    people.add(KotlinPerson(3, "Mr", "Vineet", "Raj", null))
    people.add(KotlinPerson(4, "Mrs", "Chandani", "Kumari", null))

    for (person: KotlinPerson in people) {
        println(person)
        println(person.title)
        val (id, sname) = person //destructuring
        println("$id has $sname")
    }

    //destructuring as part of loop
    for ((id, title, fname, sname, dob) in people) {
        println("$fname has id of $id but DOB of $dob")
    }

    for (i in 0..5)
        println(i)

    (10..15).forEach { i -> println(i) }
    (16..20).forEach { println(it) } //shorter form of above
    (8 downTo 5).forEach { println(it) } //descending
    (2 until 7).forEach { println(it) } //excluding 7
    (0..9 step 3).forEach { println(it) } //gap of 3
    ('A'..'K').forEach { i -> println(i) } //with chars
}
