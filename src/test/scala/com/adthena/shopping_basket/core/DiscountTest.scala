package com.adthena.shopping_basket.core

import com.adthena.shopping_basket.core.offer.{MultiOffer, SimpleDiscountOffer}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class DiscountTest extends AnyFunSuite with Matchers {

  // items
  val apples: Item = Item("apples", Price(100))
  val milk: Item = Item("milk", Price(130))
  val bread: Item = Item("bread", Price(80))
  val soup: Item = Item("soup", Price(65))

  // offers
  val applesOffer: MultiOffer = new SimpleDiscountOffer("Apples 10% off", apples, 10)
  val soupBreadOffer: MultiOffer = new MultiOffer("Buy 2 tins of soup and get bread 50% off", List(soup, soup), bread, 50)
  val allOffers: List[MultiOffer] = List(applesOffer, soupBreadOffer)


  test("evaluate() - basket with a single offer applied") {

    val basket = new Basket(List(apples, milk, bread))
    basket.getTotalCost shouldBe Price(310)

    val discount = Discount.evaluate(basket, allOffers)
    discount.priceDiscount shouldBe Price(10)
    discount.offersApplied shouldBe List(applesOffer)

  }

  test("evaluate() - basket with no offers applied") {

    val basket = new Basket(List(milk))
    basket.getTotalCost shouldBe Price(130)

    val discount = Discount.evaluate(basket, allOffers)
    discount.priceDiscount shouldBe Price(0)
    discount.offersApplied.isEmpty shouldBe true

  }

  test("evaluate() - basket with all the offers applied") {

    val basket = new Basket(List(apples, milk, bread, soup, soup))
    basket.getTotalCost shouldBe Price(440)

    val discount = Discount.evaluate(basket, allOffers)
    discount.priceDiscount shouldBe Price(50)
    discount.offersApplied shouldBe allOffers

  }

}