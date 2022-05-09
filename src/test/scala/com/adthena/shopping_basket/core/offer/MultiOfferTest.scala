package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Item, Price}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class MultiOfferTest extends AnyFunSuite with Matchers {

  test("multi item offer") {

    // items
    val soup: Item = Item("Soup", Price(65))
    val bread: Item = Item("Bread", Price(80))

    // offer
    val soupBreadOffer: MultiOffer = new MultiOffer("Buy 2 tins of soup and get bread 50% off", List(soup, soup), bread, 50)

    soupBreadOffer.name shouldBe "Buy 2 tins of soup and get bread 50% off"
    soupBreadOffer.requiredItems shouldBe List(soup, soup)
    soupBreadOffer.discountedItem shouldBe bread
    soupBreadOffer.priceDiscount shouldBe Price(40)
    soupBreadOffer.toString shouldBe "Buy 2 tins of soup and get bread 50% off: 40p"

  }

}