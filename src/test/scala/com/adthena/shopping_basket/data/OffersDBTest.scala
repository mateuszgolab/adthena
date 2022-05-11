package com.adthena.shopping_basket.data

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class OffersDBTest extends AnyFunSuite with Matchers {


  test("getCurrentOffers()") {

    val result = OffersDB.getCurrentOffers

    result.isEmpty shouldBe false
    result.length shouldBe 2
    result.map(r => r.name).sorted shouldBe List("Apples 10% off", "Buy 2 tins of soup and get bread 50% off")

  }


}