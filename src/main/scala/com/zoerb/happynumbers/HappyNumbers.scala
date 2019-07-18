package com.zoerb.happynumbers


object HappyNumbers {

  def computeAllHappyNumbers(range: Range): Seq[Int] = {
    range.filter(isHappyNumber)
  }

  def isHappyNumber(i: Int): Boolean = {
    // Mask `i` to ensure the outer parameter can't be seen from the recursive function
    @annotation.tailrec
    def recur(i: Int, visited: Set[Int]): Boolean = {
      if (i == 1)
        true
      else if (visited.contains(i))
        false
      else
        recur(calculateDigitSquareSum(i), visited + i)
    }

    recur(i, Set())
  }

  def calculateDigitSquareSum(i: Int): Int = {
    sumOfSquares(splitIntoDigits(i))
  }

  def splitIntoDigits(i: Int): Seq[Int] = {
    @annotation.tailrec
    def recur(i: Int, digits: List[Int]): List[Int] = {
      if (i == 0) digits
      else recur(i / 10, i % 10 +: digits)
    }

    recur(i, List())
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
  def splitIntoDigits_toString(i: Int): Seq[Int] = {
    require(i >= 0)
    i.toString.map(_.asDigit)
  }

  def splitIntoDigits_iterative(i: Int): Seq[Int] = {
    import scala.collection.mutable.ListBuffer

    var num = i
    val digits = ListBuffer[Int]()

    while (num != 0) {
      digits.prepend(num % 10)
      num /= 10
    }

    digits
  }

  // Less clear, but iterates over seq once instead of twice.  Could otherwise
  // use a view but it'd be overkill for this use case.
  def sumOfSquares_fold(nums: Seq[Int]): Int = {
    import HappyNumbers.sq

    nums.foldLeft(0)(_ + sq(_))
  }
}


// TODO
// - memoize
// - parallelize
