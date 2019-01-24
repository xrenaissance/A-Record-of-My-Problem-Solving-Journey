package Fundation.basics

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 1) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} likes fucking ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_! : String = s"${this.name}, what hack!!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def apply(): String = s"Hi ${this.name}, I like watching $favoriteMovie, I am $age years old."
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times."
    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")
  // infix notation = operator notation (syntactic sugar)

  // "operator" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(!mary)
  println(mary.unary_!)
  println(mary.apply())
  println(mary())
  println((mary + "rock star").apply())
  println((mary.unary_+).apply())
  println((+mary).apply())
  println(mary learnsScala)
  println(mary.learns("Python"))
  println(mary.apply(8))
}
