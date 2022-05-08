package com.adthena.shopping_basket.offer

import com.adthena.shopping_basket.Item
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class OfferTest extends AnyFunSuite with Matchers {

  test("multi item offer") {

    // items
    val soup: Item = Item("soup", 65)
    val bread: Item = Item("bread", 80)

    val soupBreadOffer: Offer = new Offer("Buy 2 tins of soup and get bread 50% off", List(soup, soup), List(bread), 50)

    soupBreadOffer.name shouldBe "Buy 2 tins of soup and get bread 50% off"
    soupBreadOffer.requiredItems shouldBe List(soup, soup)
    soupBreadOffer.discountedItems shouldBe List(bread)
    soupBreadOffer.discountValue shouldBe 40

  }

}