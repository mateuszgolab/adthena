package com.adthena.shopping_basket.core

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ItemTest extends AnyFunSuite with Matchers {


  test("valid Item") {

    val bread: Item = Item("bread", Price(80))

    bread.name shouldBe "bread"
    bread.price shouldBe Price(80)

  }

  test("an item with empty name") {

    val thrown = intercept[Exception] {
      Item("", Price(80))
    }

    thrown.getMessage shouldBe "requirement failed: item must have a name"

  }

  test("an item with a null name") {

    val thrown = intercept[Exception] {
      Item(null, Price(80))
    }

    thrown.getMessage shouldBe "requirement failed: item must have a name"

  }

  test("an item with a null price") {

    val thrown = intercept[Exception] {
      Item("name", null)
    }

    thrown.getMessage shouldBe "requirement failed: item must have a price"

  }

}
