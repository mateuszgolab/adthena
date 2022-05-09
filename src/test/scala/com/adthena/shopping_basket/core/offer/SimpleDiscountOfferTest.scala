package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Item, Price}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SimpleDiscountOfferTest extends AnyFunSuite with Matchers{

  test("simple offer test") {

    val apples: Item = Item("Apples", Price(210))
    val applesOffer = new SimpleDiscountOffer("Apples 10% off", apples, 10)

    applesOffer.name shouldBe "Apples 10% off"
    applesOffer.requiredItems shouldBe List(apples)
    applesOffer.discountedItem shouldBe apples
    applesOffer.priceDiscount shouldBe Price(21)
    applesOffer.toString shouldBe "Apples 10% off: 21p"

  }

}