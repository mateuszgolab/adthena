package com.adthena.shopping_basket

import com.adthena.shopping_basket.offer.{Offer, SimpleDiscountOffer}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class DiscountTest extends AnyFunSuite with Matchers {

  // items
  val apples: Item = Item("apples", 100)
  val milk: Item = Item("milk", 130)
  val bread: Item = Item("bread", 80)
  val soup: Item = Item("soup", 65)

  // offers
  val applesOffer: Offer = new SimpleDiscountOffer("Apples 10% off", apples, 10)
  val soupBreadOffer: Offer = new Offer("Buy 2 tins of soup and get bread 50% off", List(soup, soup), List(bread), 50)
  val allOffers: List[Offer] = List(applesOffer, soupBreadOffer)

  test("NoDiscount() - no discounts applied") {

    val discount = NoDiscount()

    discount.discountValue shouldBe 0
    discount.offersApplied.isEmpty shouldBe true

  }

  test("evaluate() - basket with a single offer applied") {

    val basket = new Basket(List(apples, milk, bread))
    basket.getTotalCost shouldBe 310

    val discount = Discount.evaluate(basket, allOffers)
    discount.discountValue shouldBe 10
    discount.offersApplied shouldBe List(applesOffer)

  }

  test("evaluate() - basket with no offers applied") {

    val basket = new Basket(List(milk))
    basket.getTotalCost shouldBe 130

    val discount = Discount.evaluate(basket, allOffers)
    discount shouldBe a[NoDiscount]

  }

  test("evaluate() - basket with all the offers applied") {

    val basket = new Basket(List(apples, milk, bread, soup, soup))
    basket.getTotalCost shouldBe 440

    val discount = Discount.evaluate(basket, allOffers)
    discount.discountValue shouldBe 50
    discount.offersApplied shouldBe allOffers

  }

}