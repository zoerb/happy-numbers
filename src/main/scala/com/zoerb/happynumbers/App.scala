package com.zoerb.happynumbers

import scala.util.Try


object App {
  def main(args: Array[String]): Unit = {
    args match {
      // Print out all happy numbers between 1 and 1000
      case Array() =>
        val allHappyNums = (1 to 1000).filter(HappyNumbers.isHappyNumber)
        println(allHappyNums.mkString(", "))

      // Test if given number is happy
      case Array(numStr) =>
        val num = Try(numStr.toInt).getOrElse {
          println("Error: argument must be an integer")
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
