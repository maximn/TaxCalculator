package com.maxondev

import org.specs2.mutable.Specification

/**
 * User: maximn
 * Date: 12/15/14
 */
class TaxCalculatorTest extends Specification {

  val calc = new TaxCalculator()

  "calculator" should {
    "1st level of tax" in {
      calc.calculate(5000) must beCloseTo(500.0, 0.1)
    }

    "2nd level of tax" in {
      calc.calculate(5800) must beCloseTo(609.2, 0.1)
    }

    "last level of tax" in {
      calc.calculate(50000) must beCloseTo(15068.1, 0.1)
    }

    "fail on a negative input" in {
      calc.calculate(-1) must throwA[IllegalArgumentException]
    }

    "be 0 for 0 salary" in {
      calc.calculate(0) must beEqualTo(0.0)
    }

    "exactly upper bound of a tax level" in {
      calc.calculate(8660) must beCloseTo(1009.6, 0.1)
    }

    "exactly lower bound of a tax level" in {
      calc.calculate(8661) must beCloseTo(1009.83, 0.1)
    }
  }
}
