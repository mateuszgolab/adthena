package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Basket, Item, Price}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SimpleDiscountOfferTest extends AnyFunSuite with Matchers{

  test("simple offer test") {

    // items
    val apples: Item = Item("Apples", Price(210))
    val bread: Item = Item("Bread", Price(80))

    // offer
    val applesOffer = new SimpleDiscountOffer("Apples 10% off", apples, 10)

    // baskets
    val applicableBasket = new Basket(List(apples))
    val nonApplicableBasket = new Basket(List(bread))

    applesOffer.name shouldBe "Apples 10% off"
    applesOffer.discountedItem shouldBe apples
    applesOffer.priceDiscount shouldBe Price(21)
    applesOffer.getApplicationsCount(applicableBasket) shouldBe 1
    applesOffer.getTotalDiscount(applicableBasket) shouldBe Price(21)
    applesOffer.getApplicationsCount(nonApplicableBasket) shouldBe 0
    applesOffer.getTotalDiscount(nonApplicableBasket) shouldBe Price(0)

  }

  test("simple offer test with multiple items applicable") {

    // items
    val apples: Item = Item("Apples", Price(210))

    // offer
    val applesOffer = new SimpleDiscountOffer("Apples 10% off", apples, 10)

    // baskets
    val applicableBasket = new Basket(List(apples, apples))

    applesOffer.name shouldBe "Apples 10% off"
    applesOffer.discountedItem shouldBe apples
    applesOffer.priceDiscount shouldBe Price(21)
    applesOffer.getApplicationsCount(applicableBasket) shouldBe 2
    applesOffer.getTotalDiscount(applicableBasket) shouldBe Price(42)

  }

}