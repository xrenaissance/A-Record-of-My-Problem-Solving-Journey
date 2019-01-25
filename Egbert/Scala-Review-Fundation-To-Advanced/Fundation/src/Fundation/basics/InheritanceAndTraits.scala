package Fundation.basics

/**
  * preventing overrides
  * 1 - use final final on member
  * 2 - use final on the entire class
  * 3 - sealed
  */
object InheritanceAndTraits extends App {
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType = "domestic"

    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (board: polymorphism)
  val unknownAniml: Animal = new Dog("K9")
  unknownAniml.eat




}
