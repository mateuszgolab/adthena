package com.adthena.shopping_basket.data

import com.adthena.shopping_basket.core.Price
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ItemsDBTest extends AnyFunSuite with Matchers {


  test("getItem() - existing item") {

    val result = ItemsDB.getItem("soup")

    result.nonEmpty shouldBe true
    result.get.name shouldBe "Soup"
    result.get.price shouldBe Price(65)

  }

  test("getItem() - non existing item") {

    val result = ItemsDB.getItem("chocolate")

    result.nonEmpty shouldBe false

  }


}