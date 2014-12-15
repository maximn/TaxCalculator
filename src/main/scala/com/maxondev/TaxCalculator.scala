package com.maxondev

/**
 * User: maximn
 * Date: 12/15/14
 */

// http://ayende.com/blog/108545/the-tax-calculation-challenge
class TaxCalculator {
  private val rates = Seq(
    TaxForWindow(1, 5070, 10),
    TaxForWindow(5071, 8660, 14),
    TaxForWindow(8661, 14070, 23),
    TaxForWindow(14071, 21240, 30),
    TaxForWindow(21241, 40230, 33),
    TaxForWindow(40231, Int.MaxValue, 45))


  def calculate(salary: Double): Double = {
    require(salary >= 0)

    def ratesForSalary = rates.reverse.dropWhile(_.from > salary)
    calculateInternal(salary, ratesForSalary)
  }


  private def taxForWindow(salary: Double, window: TaxForWindow): Double = {
    (salary - (window.from - 1)) * window.percentage / 100
  }


  private def calculateInternal(salary: Double, rates: Seq[TaxForWindow]): Double =
    rates match {
      case head :: tail => calculateInternal(head.from - 1, tail) + taxForWindow(salary, head)
      case Nil => 0
    }

  case class TaxForWindow(from: Double, to: Double, percentage: Double)
}


// Some other solutions -
// 1. tail recursion - will be converted to a loop at compile time.

// @scala.annotation.tailrec
// private def calculateInternal(salary: Double, accumulator: Double, rates: Seq[TaxForWindow]): Double =
//   rates match {
//   case head :: tail => calculateTailrec(head.from - 1, accumulator + taxForWindow(salary, head), tail)
//   case Nil => accumulator
// }


// 2. using .fold
// private def calculateInternal(salary: Double, rates: Seq[TaxForWindow]): Double =
//   rates.foldLeft(0d)((accum, taxFor) => {
//   val taxForWindow = Math.min(taxFor.to - (taxFor.from - 1), salary - (taxFor.from - 1))
//   accum + (taxForWindow * (taxFor.percentage / 100))
// })

