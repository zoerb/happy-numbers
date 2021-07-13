package com.zoerb.happynumbers


object HappyNumbers {

  def isHappyNumber(num: Int): Boolean = {
    @annotation.tailrec
    def recur(i: Int, visited: Set[Int]): Boolean = {
      if (i == 1)
        true
      else if (visited.contains(i))
        false
      else
        recur(calculateDigitSquareSum(i), visited + i)
    }

    recur(num, Set())
  }

  def calculateDigitSquareSum(num: Int): Int = {
    sumOfSquares(splitIntoDigits(num))
  }

  def splitIntoDigits(num: Int): Seq[Int] = {
    @annotation.tailrec
    def recur(i: Int, digits: List[Int]): List[Int] = {
      if (i == 0) digits
      else recur(i / 10, i % 10 +: digits)
    }

    recur(num, List())
  }

  def sumOfSquares(nums: Seq[Int]): Int = {
    nums.map(sq).sum
  }

  def sq(x: Int): Int = x * x
}


object HappyNumbersAlts {
  // Concise, but conceptually impure, doesn't work with negatives, dependent on toString
  // output (e.g. what if a version of toString separated digit triples by commas).  Also
  // - admittedly getting increasingly pedantic here - it's limited to base 10 numbers.
  def splitIntoDigits_toString(num: Int): Seq[Int] = {
    require(num >= 0)
    num.toString.map(_.asDigit)
  }

  def splitIntoDigits_iterative(num: Int): Seq[Int] = {
    import scala.collection.mutable.ListBuffer

    var i = num
    val digits = ListBuffer[Int]()

    while (i != 0) {
      digits.prepend(i % 10)
      i /= 10
    }

    digits.toSeq
  }

  // Less clear, but iterates over seq once instead of twice.  Could otherwise
  // use a view but it'd be overkill for this use case.
  def sumOfSquares_fold(nums: Seq[Int]): Int = {
    import HappyNumbers.sq

    nums.foldLeft(0)(_ + sq(_))
  }
}
