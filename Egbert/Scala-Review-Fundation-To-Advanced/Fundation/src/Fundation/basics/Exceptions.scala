package Fundation.basics

/**
  * Created by Egbert Li
  * 28/01/2019
  */
object Exceptions extends App {
  val x: String = null

  // println(x.length)
  // this ^^ will crash with a NPE

  // 1. throwing exception
  // val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42
  }

  val potentialFail = try {
    // code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will get executed
    println("finally")
  }
  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException

  // throw exception
  /*
  1. Crash your program with an OutOfMemoError
  2. Crash with SOError
  3. PocketCalcultor
    - add(x, y)
    - substract(x, y)
    - multiply(x, y)
    - divide(x, y)
    Throw
    - OverflowException if add(x,y) exceeds Int.MAX_VALUE
    - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
    - MathCalculationException for division by 0
   */
  // OOM
  // val array = Array.ofDim(Int.Max
  // def infinite: Int = 1 + infinite
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Ddivision by 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def substract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0 ) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
      }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2,0))
}
