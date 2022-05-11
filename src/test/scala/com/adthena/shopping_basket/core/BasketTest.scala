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
  val basket = new Basket(List(soup, bread, bread, milk, apples))


  test("getTotalCost() - empty basket") {

    emptyBasket.getTotalCost shouldBe Price(0)

  }

  test("getTotalCost() - total basket cost without offers") {

    basket.getTotalCost shouldBe Price(455)

  }

  test("contains() - basket contains given items") {

    val items = List(bread, bread, soup)

    basket.contains(items) shouldBe true

  }

  test("contains() - basket does not contain all given items") {

    val items = List(bread, bread, bread, soup)

    basket.contains(items) shouldBe false

  }

  test("contains() - basket contains empty list of items") {

    val items = List().empty

    basket.contains(items) shouldBe true

  }

  test("contains() - basket does not contain a given item") {

    emptyBasket.contains(bread) shouldBe false

  }

  test("contains() - basket contains a given item") {

    basket.contains(bread) shouldBe true

  }

  test("auxiliary constructor") {

    val input: Array[Try[Item]] = Array[Try[Item]](Try(soup), Failure(new Exception("test")))
    val basket = new Basket(input)

    basket.contains(soup) shouldBe true

  }


}
