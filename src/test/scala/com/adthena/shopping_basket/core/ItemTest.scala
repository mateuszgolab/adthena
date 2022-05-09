package com.adthena.shopping_basket.core

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ItemTest extends AnyFunSuite with Matchers{

  val bread: Item = Item("bread", Price(80))

  test("get name") {

    bread.name shouldBe "bread"

  }

  test("get price") {

    bread.price shouldBe Price(80)

  }

}
