package com.adthena.shopping_basket.core

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PriceTest extends AnyFunSuite with Matchers {

  test("price in pound") {

    val price = Price(200)

    price.value shouldBe 200
    price.toString shouldBe "£2.00"

  }

  test("price in pence") {

    val price = Price(65)

    price.value shouldBe 65
    price.toString shouldBe "65p"

  }

  test("price in pound and pence") {

    val price = Price(210)

    price.value shouldBe 210
    price.toString shouldBe "£2.10"

  }

  test("price zero") {

    val price = Price(0)

    price.value shouldBe 0
    price.toString shouldBe "0p"

  }

  test("invalid price") {

    val thrown = intercept[Exception] {
      Price(-65)
    }

    thrown.getMessage shouldBe "requirement failed: price can't be a negative value"

  }

}