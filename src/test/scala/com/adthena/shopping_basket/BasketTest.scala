package com.adthena.shopping_basket

import org.scalatest.funsuite.AnyFunSuite

class BasketTest extends AnyFunSuite {

  // empty basket
  val emptyBasket = new Basket(List().empty)

  // non empty basket
  val soup: Item = Item("soup", 65)
  val bread: Item = Item("bread", 80)
  val milk: Item = Item("milk", 130)
  val apples: Item = Item("apples", 100)
  val basket = new Basket(List(soup, bread, bread, milk, apples))


  test("getTotalCost() - empty basket") {

    assert(emptyBasket.getTotalCost == 0)

  }

  test("getTotalCost() - total basket cost without offers") {

    assert(basket.getTotalCost == 455)

  }

  test("contains() - basket contains given items") {

    val items = List(bread, bread, soup)

    assert(basket.contains(items))

  }

  test("contains() - basket does not contain all given items") {

    val items = List(bread, bread, bread, soup)

    assert(!basket.contains(items))

  }

  test("contains() - basket contains empty list of items") {

    val items = List().empty

    assert(basket.contains(items))

  }


}
