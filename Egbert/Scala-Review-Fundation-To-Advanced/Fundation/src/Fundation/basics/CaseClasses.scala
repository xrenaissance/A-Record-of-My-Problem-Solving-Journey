package Fundation.basics

/**
  * Created by Egbert
  */
object CaseClasses extends App {
  /**
    * Quick lightweight data structure with little boilerplate
    * Companions already implemented
    * Sensible equals, hashCode, toString
    * Auto-promoted params to fields
    * Cloning
    * case objects
    */
  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy methjod
  val jim3 = jim.copy(age = 99)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING
  case object UnitedKindom {
    def name: String = "The UK of GB and NI"
  }
}
