package com.zoerb.happynumbers

import scala.collection.mutable


/** Memoized version
  *
  * Stores results (including intermediate `visited` chain) from previous runs
  * to shortcut computation for numbers seen already.
  *
  * Note that unlike the non-memoized version, this version is not thread-safe.
  */
class HappyNumbersMemo {
  // Could replace these with concurrent sets if thread safety is needed
  private val happyCache = new mutable.HashSet[Int]
  private val unhappyCache = new mutable.HashSet[Int]

  def isHappyNumber(i: Int): Boolean = {
    @annotation.tailrec
    def recur(i: Int, visited: Set[Int]): Boolean = {
      if (i == 1 || happyCache.contains(i)) {
        happyCache ++= visited + i
        true
      } else if (visited.contains(i) || unhappyCache.contains(i)) {
        unhappyCache ++= visited + i
        false
      } else {
        recur(HappyNumbers.calculateDigitSquareSum(i), visited + i)
      }
    }

    recur(i, Set())
  }
}
