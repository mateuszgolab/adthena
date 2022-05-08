package com.adthena.shopping_basket
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ItemTest extends AnyFunSuite with Matchers{

  val bread: Item = Item("bread", 80)

  test("get name") {

    bread.name shouldBe "bread"

  }

  test("get price") {

    bread.price shouldBe 80

  }

}
