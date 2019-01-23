package Fundation.basics

object CBNvsCBV extends App {

  /**
    * Call by value:
    * value is computed before call
    * same value used everywhere
    */
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  /**
    * call by name, lazy evaluation, if not used, it will not be evaluated
    * expression is passed literally, expression is evaluated at every use within
    * @param x
    * call by Name
    */
  def calledByName(x: => Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34)
  printFirst(34, infinite())

  def trFac(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFac(n - 1, n * acc)
  }

  val fact10 = trFac(10, 2)
  println(fact10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  savePicture(width = 800)

  /**
    * 1. pass in every leading argument
    * 2. name the arguments
    */
  savePicture(height = 600, width = 800, format = "bmp")

  /**
    * When 99% of time we call a function with same params:
     */
  def greet(name: String = "Superman", age: Int = 10): String = {
    s"Hi, I'm $name and I'm $age years old."
  }
  println(greet(age = 5))
  println(greet(name="Sally", age = 5))
  println(greet(age = 5, name = "dog"))

}
