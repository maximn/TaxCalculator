package com.maxondev

import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
 * User: maximn
 * Date: 12/15/14
 */
class TaxCalculatorTest extends Specification {

  trait ctx extends Scope {
    val calc = new TaxCalculator()

    def beCloseTo(d: Double) = be ~ (d +/- 0.1)
  }

  "calculator" should {
    "1st level of tax" in new ctx {
      calc.calculate(5000) must beCloseTo(500)
    }

    "2nd level of tax" in new ctx {
      calc.calculate(5800) must beCloseTo(609.2)
    }

    "last level of tax" in new ctx {
      calc.calculate(50000) must beCloseTo(15068.1)
    }

    "fail on a negative input" in new ctx {
      calc.calculate(-1) must throwA[IllegalArgumentException]
    }

    "be 0 for 0 salary" in new ctx {
      calc.calculate(0) must be_===(0)
    }

    "exactly upper bound of a tax level" in new ctx {
      calc.calculate(8660) must beCloseTo(1009.6)
    }

    "exactly lower bound of a tax level" in new ctx {
      calc.calculate(8661) must beCloseTo(1009.83)
    }
  }
}
