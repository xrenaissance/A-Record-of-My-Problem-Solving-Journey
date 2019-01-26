package Fundation.basics

/**
  * We can instantiate types and override fields or methods on the spot
  * trait Animal {
  *   def eat: Unit
  * }
  * val predator = new Animal {
  *   override def eat: Unit = println("RAWR!")
  * }
  * Rules:
  *   - pass in required constructor arguments if needed
  *   - implement all abstract fields/methods
  *   Created by Egbert
  */
object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahaha")
  }
  /**
    * equivalent to
    * class AnonymousClasses$$anon$1 extends Animal {
    *   override def eat: Unit = println("ahahhha")
    * }
    * val funnyAnimal: Animal = new AnonymousClasses$$anon$1
    */
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }
  val jim = new Person("Jim") {
    override def sayHi = println(s"Hi, my name is Jim, how can I be of service?")
  }
  jim.sayHi
}
