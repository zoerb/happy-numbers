package com.zoerb.happynumbers


object App {
  def main(args: Array[String]): Unit = {
    args.length match {
      case 0 => 
        // Print out all happy numbers between 1 and 1000
        val allHappyNums = HappyNumbers.computeAllHappyNumbers(1, 1000)
        println(allHappyNums.mkString(", "))
      case 1 =>
        // Test if given number is happy
        try {
          val num = args.head.toInt
          val isHappy = HappyNumbers.isHappyNumber(num)

          if (isHappy)
            println(s"$num is happy")
          else
            println(s"$num is not happy")
        } catch {
          case _: NumberFormatException => println("Argument must be an integer")
        }
      case _ =>
        println("Usage: happy-numbers [number]")
    }
  }
}
