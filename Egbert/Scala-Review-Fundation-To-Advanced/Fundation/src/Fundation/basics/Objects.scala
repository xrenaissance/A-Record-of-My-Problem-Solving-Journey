package Fundation.basics

/**
  * Scala objects
  * - are in their own class
  * - are the only instance
  * - singleton pattern in one line!
  * Scala companions
  * - can access each other's private members
  * - Scala is more OO than Java
  */
object Objects {
  // Scala does not have class-level functionality ("static")
  object Person { // type + its only instance
    // "static" / "class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false
  }

  class Person(val name: String) {
    // instance-level functionality

  }
  def main(args: Array[String]): Unit = {
    // COMPANIONS
    println(Person.N_EYES)
    println(Person.canFly)
    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)
  }
}
