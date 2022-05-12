package com.adthena.shopping_basket.core

import com.adthena.shopping_basket.core.offer.{MultiOffer, Offer, SimpleDiscountOffer}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class DiscountTest extends AnyFunSuite with Matchers {

  // items
  val apples: Item = Item("apples", Price(100))
  val milk: Item = Item("milk", Price(130))
  val bread: Item = Item("bread", Price(80))
  val soup: Item = Item("soup", Price(65))

  // offers
  val applesOffer: Offer = new SimpleDiscountOffer("Apples 10% off", apples, 10)
  val soupBreadOffer: Offer = new MultiOffer("Buy 2 tins of soup and get bread 50% off", Map(soup -> 2), bread, 50)
  val currentOffers: List[Offer] = List(applesOffer, soupBreadOffer)


  test("evaluate() - basket with a single offer applied") {

    val basket = new Basket(List(apples, milk, bread))
    basket.getTotalCost shouldBe Price(310)

    val discount = Discount.evaluate(basket, currentOffers)
    discount.totalPriceDiscount shouldBe Price(10)
    discount.applicableOffers shouldBe Map(applesOffer -> Price(10))

  }

  test("evaluate() - basket with no offers applied") {

    val basket = new Basket(List(milk))
    basket.getTotalCost shouldBe Price(130)

    val discount = Discount.evaluate(basket, currentOffers)
    discount.totalPriceDiscount shouldBe Price(0)
    discount.applicableOffers.isEmpty shouldBe true

  }

  test("evaluate() - basket with all given offers applied") {

    val basket = new Basket(List(apples, milk, bread, soup, soup))
    basket.getTotalCost shouldBe Price(440)

    val discount = Discount.evaluate(basket, currentOffers)
    discount.totalPriceDiscount shouldBe Price(50)
    discount.applicableOffers shouldBe Map(applesOffer -> Price(10), soupBreadOffer -> Price(40))

  }

  test("evaluate() - basket with a single offer applied twice") {

    val basket = new Basket(List(apples, apples))
    basket.getTotalCost shouldBe Price(200)

    val discount = Discount.evaluate(basket, currentOffers)
    discount.totalPriceDiscount shouldBe Price(20)
    discount.applicableOffers shouldBe Map(applesOffer -> Price(20))

  }

  test("evaluate() - basket with a multi offer applied twice") {

    val basket = new Basket(List(soup, soup, bread, soup, soup, bread))
    basket.getTotalCost shouldBe Price(420)

    val discount = Discount.evaluate(basket, currentOffers)
    discount.totalPriceDiscount shouldBe Price(80)
    discount.applicableOffers shouldBe Map(soupBreadOffer -> Price(80))

  }

  test("evaluate() - basket with a multi offer required items added twice but just one discounted item") {

    val basket = new Basket(List(soup, soup, bread, soup, soup))
    basket.getTotalCost shouldBe Price(340)

    val discount = Discount.evaluate(basket, currentOffers)
    discount.totalPriceDiscount shouldBe Price(40)
    discount.applicableOffers shouldBe Map(soupBreadOffer -> Price(40))

  }

}