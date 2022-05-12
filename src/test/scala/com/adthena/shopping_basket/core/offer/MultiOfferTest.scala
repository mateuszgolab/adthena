package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Basket, Item, Price}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class MultiOfferTest extends AnyFunSuite with Matchers {

  test("multi item offer") {

    // items
    val soup: Item = Item("Soup", Price(65))
    val bread: Item = Item("Bread", Price(80))

    // baskets
    val applicableBasket = new Basket(List(soup, soup, bread))
    val nonApplicableBasket = new Basket(List(soup, bread))

    // offer
    val soupBreadOffer: MultiOffer = new MultiOffer("Buy 2 tins of soup and get bread 50% off", Map(soup -> 2), bread, 50)

    soupBreadOffer.name shouldBe "Buy 2 tins of soup and get bread 50% off"
    soupBreadOffer.requiredItems shouldBe Map(soup -> 2)
    soupBreadOffer.discountedItem shouldBe bread
    soupBreadOffer.priceDiscount shouldBe Price(40)
    soupBreadOffer.getApplicationsCount(applicableBasket) shouldBe 1
    soupBreadOffer.getTotalDiscount(applicableBasket) shouldBe Price(40)
    soupBreadOffer.getApplicationsCount(nonApplicableBasket) shouldBe 0
    soupBreadOffer.getTotalDiscount(nonApplicableBasket) shouldBe Price(0)

  }

  test("multi item offer with multiple purchases applicable") {

    // items
    val soup: Item = Item("Soup", Price(65))
    val bread: Item = Item("Bread", Price(80))

    // baskets
    val applicableBasket = new Basket(List(soup, soup, bread, soup, soup ,bread))

    // offer
    val soupBreadOffer: MultiOffer = new MultiOffer("Buy 2 tins of soup and get bread 50% off", Map(soup -> 2), bread, 50)

    soupBreadOffer.name shouldBe "Buy 2 tins of soup and get bread 50% off"
    soupBreadOffer.requiredItems shouldBe Map(soup -> 2)
    soupBreadOffer.discountedItem shouldBe bread
    soupBreadOffer.priceDiscount shouldBe Price(40)
    soupBreadOffer.getApplicationsCount(applicableBasket) shouldBe 2
    soupBreadOffer.getTotalDiscount(applicableBasket) shouldBe Price(80)

  }

  test("multi item offer with multiple qualifying items, but single discounted item") {

    // items
    val soup: Item = Item("Soup", Price(65))
    val bread: Item = Item("Bread", Price(80))

    // baskets
    val applicableBasket = new Basket(List(soup, soup, bread, soup, soup))

    // offer
    val soupBreadOffer: MultiOffer = new MultiOffer("Buy 2 tins of soup and get bread 50% off", Map(soup -> 2), bread, 50)

    soupBreadOffer.name shouldBe "Buy 2 tins of soup and get bread 50% off"
    soupBreadOffer.requiredItems shouldBe Map(soup -> 2)
    soupBreadOffer.discountedItem shouldBe bread
    soupBreadOffer.priceDiscount shouldBe Price(40)
    soupBreadOffer.getApplicationsCount(applicableBasket) shouldBe 1
    soupBreadOffer.getTotalDiscount(applicableBasket) shouldBe Price(40)

  }

}