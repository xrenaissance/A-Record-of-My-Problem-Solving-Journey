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
}
