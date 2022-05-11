package com.adthena.shopping_basket.parsing

import com.adthena.shopping_basket.core.Item
import com.adthena.shopping_basket.data.ItemsDB
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

import scala.util.Try

class ItemParserTest extends AnyFunSuite with Matchers{

  // items
  val soup: Item = ItemsDB.getItem("soup").get
  val bread: Item = ItemsDB.getItem("bread").get
  val milk: Item = ItemsDB.getItem("milk").get
  val apples: Item = ItemsDB.getItem("apples").get

  test("parseItems() valid input") {

    // given
    val input : Array[String] = Array("Apples", "Milk", "Bread")

    // when
    val result: Array[Try[Item]] = ItemParser.parseItems(input)

    // then
    result.length shouldBe input.length
    result.flatMap(_.toOption).length shouldBe input.length
    result.exists(_.isFailure) shouldBe false

  }

  test("parseItems() valid input - lowercase") {

    // given
    val input : Array[String] = Array("apples", "milk", "bread")

    // when
    val result = ItemParser.parseItems(input)

    // then
    result.length shouldBe input.length
    result.flatMap(_.toOption).length shouldBe input.length
    result.exists(_.isFailure) shouldBe false

  }

  test("parseItems() valid input - uppercase") {

    // given
    val input : Array[String] = Array("APPLES", "MILK", "BREAD")

    // when
    val result = ItemParser.parseItems(input)

    // then
    result.length shouldBe input.length
    result.flatMap(_.toOption).length shouldBe input.length
    result.exists(_.isFailure) shouldBe false

  }

  test("parseItems() invalid input") {

    // given
    val input : Array[String] = Array("sdf", "chocolate", "invalid")

    // when
    val result = ItemParser.parseItems(input)

    // then
    result.length shouldBe input.length
    result.flatMap(_.toOption).isEmpty shouldBe true
    result.count(_.isFailure) shouldBe input.length

  }

  test("parseItems() partially valid input") {

    // given
    val input : Array[String] = Array("soup", "chocolate", "invalid")

    // when
    val result = ItemParser.parseItems(input)

    // then
    result.length shouldBe input.length
    result.flatMap(_.toOption).length shouldBe 1
    result.count(_.isFailure) shouldBe 2

  }

}
