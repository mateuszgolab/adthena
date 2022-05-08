package com.adthena.shopping_basket.offer

import com.adthena.shopping_basket.Item
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SimpleDiscountOfferTest extends AnyFunSuite with Matchers{

  test("simple offer test") {

    val apples: Item = Item("apples", 210)
    val applesOffer = new SimpleDiscountOffer("Apples 10% off", apples, 10)

    applesOffer.name shouldBe "Apples 10% off"
    applesOffer.requiredItems shouldBe List(apples)
    applesOffer.discountedItems shouldBe List(apples)
    applesOffer.discountValue shouldBe 21

  }

}