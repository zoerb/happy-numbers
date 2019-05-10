package com.zoerb.happynumbers


object HappyNumbers {
  def computeAllHappyNumbers(min: Int, max: Int): Seq[Int] = {
    Range.inclusive(min, max).filter(isHappyNumber)
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

  // Easy to update for splitting by bases other than 10
  def splitIntoDigits(i: Int): Seq[Int] = {
    @annotation.tailrec
    def recur(i: Int, digits: Seq[Int]): Seq[Int] = {
      if (i == 0) digits
      else recur(i / 10, i % 10 +: digits)
    }

    recur(i, Seq())
  }

  def sumOfSquares(nums: Seq[Int]): Int = {
    nums.map(sq).sum
  }

  def sq(x: Int): Int = x * x
}


object HappyNumbersAlts {
  import HappyNumbers.sq

  // Concise, but conceptually impure, doesn't work with negatives, dependent on toString
  // output (e.g. what if a version of toString separated digit triples by commas)
  def splitIntoDigits_toString(i: Int): Seq[Int] = {
    require(i >= 0)
    i.toString.map(_.asDigit)
  }

  // Less clear, but iterates over seq once instead of twice
  def sumOfSquares(nums: Seq[Int]): Int = {
    nums.foldLeft(0)(_ + sq(_))
  }
}


// TODO
// - memoize
// - parallelize
