package com.zoerb.happynumbers

import scala.util.Try


object App {
  def main(args: Array[String]): Unit = {
    args match {
      case Array() =>
        // Print out all happy numbers between 1 and 1000
        val allHappyNums = HappyNumbers.computeAllHappyNumbers(1 to 1000)
        println(allHappyNums.mkString(", "))
      case Array(numStr) =>
        // Test if given number is happy
        val num = Try(numStr.toInt).getOrElse {
          println("Argument must be an integer")
          return
        }

        val isHappy = HappyNumbers.isHappyNumber(num)

        if (isHappy)
          println(s"$num is happy")
        else
          println(s"$num is not happy")
      case _ =>
        println("Usage: happy-numbers [number]")
    }
  }
}
