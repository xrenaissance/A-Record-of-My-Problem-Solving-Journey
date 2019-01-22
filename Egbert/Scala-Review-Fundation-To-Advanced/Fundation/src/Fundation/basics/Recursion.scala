package Fundation.basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
   if (n <= 1) 1
   else {
     println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
     val result = n * factorial(n - 1)
     println("Computed factorial of " + n)
     result
   }
  }
  println(factorial(10))
  // Stackoverflow happens when the recursive depth is too big
  //println(factorial(5000))
  def anotherFactorial(n: Int): BigInt = {
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }
    factHelper(n, 1)
  }
  println("---- "+ anotherFactorial(10))

  /**
    * Concatenate a string n times
    * @param w word that needs to repeate
    * @param n no of times
    * @return repeated words
    */
  def concatString(w: String, n: Int): String = {
    def concatHelper(tempWord: String, accumulator: String, x: Int): String = {
      if (x <= 0) accumulator
      else concatHelper(tempWord, accumulator + tempWord, x - 1)
    }
    concatHelper(w, "", n)
  }
  println(concatString("hello", 3))

  /**
    * Check if the number is prime or not
    * @param n
    * @return
    */
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeTailrec(n / 2, true)
  }
  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }
  println(" --  " + fibonacci(8)) // 1 1 2 3 5 8 13 21
}






















