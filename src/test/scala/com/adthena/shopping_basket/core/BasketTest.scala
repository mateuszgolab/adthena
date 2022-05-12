package com.adthena.shopping_basket.core

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import scala.util.{Failure, Try}

class BasketTest extends AnyFunSuite with Matchers {

  // empty basket
  val emptyBasket = new Basket(List().empty)

  // non empty basket
  val soup: Item = Item("soup", Price(65))
  val bread: Item = Item("bread", Price(80))
  val milk: Item = Item("milk", Price(130))
  val apples: Item = Item("apples", Price(100))


  test("getTotalCost() - empty basket") {

    emptyBasket.getTotalCost shouldBe Price(0)

  }

  test("getTotalCost() - total basket cost without offers") {

    val basket = new Basket(List(soup, bread, bread, milk, apples))
    basket.getTotalCost shouldBe Price(455)

  }

  test("count() - single item") {

    val basket = new Basket(List(bread, apples))

    basket.count(bread) shouldBe 1
    basket.count(apples) shouldBe 1

  }

  test("count() - no items in the basket") {

    val basket = new Basket(List(soup))

    basket.count(bread) shouldBe 0

  }

  test("count() - empty basket") {

    emptyBasket.count(bread) shouldBe 0

  }


  test("auxiliary constructor") {

    val input: Array[Try[Item]] = Array[Try[Item]](Try(soup), Failure(new Exception("test")))
    val basket = new Basket(input)

    basket.count(soup) shouldBe 1

  }


}
