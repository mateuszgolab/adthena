package com.adthena.shopping_basket.parsing

import com.adthena.shopping_basket.core.{Basket, Item}
import com.adthena.shopping_basket.data.ItemsDB
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class BasketParserTest extends AnyFunSuite with Matchers{

  // items
  val soup: Item = ItemsDB.getItem("soup").get
  val bread: Item = ItemsDB.getItem("bread").get
  val milk: Item = ItemsDB.getItem("milk").get
  val apples: Item = ItemsDB.getItem("apples").get

  test("parseItems() valid input") {

    // given
    val input : Array[String] = Array("Apples", "Milk", "Bread")
    val expectedBasket =  new Basket(List(apples, milk, bread))

    // when
    val result = BasketParser.parseItems(input)

    // then
    result.items shouldBe expectedBasket.items
    result.getTotalCost shouldBe expectedBasket.getTotalCost

  }

  test("parseItems() valid input - lowercase") {

    // given
    val input : Array[String] = Array("apples", "milk", "bread")
    val expectedBasket =  new Basket(List(apples, milk, bread))

    // when
    val result = BasketParser.parseItems(input)

    // then
    result.items shouldBe expectedBasket.items
    result.getTotalCost shouldBe expectedBasket.getTotalCost

  }

  test("parseItems() invalid input") {

    // given
    val input : Array[String] = Array("sdf", "chocolate", "invalid")
    val expectedBasket =  new Basket(List().empty)

    // when
    val result = BasketParser.parseItems(input)

    // then
    result.items shouldBe expectedBasket.items
    result.getTotalCost shouldBe expectedBasket.getTotalCost

  }

  test("parseItems() partially valid input") {

    // given
    val input : Array[String] = Array("soup", "chocolate", "invalid")
    val expectedBasket =  new Basket(List(soup))

    // when
    val result = BasketParser.parseItems(input)

    // then
    result.items shouldBe expectedBasket.items
    result.getTotalCost shouldBe expectedBasket.getTotalCost

  }

}
