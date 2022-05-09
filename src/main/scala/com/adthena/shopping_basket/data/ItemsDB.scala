package com.adthena.shopping_basket.data

import com.adthena.shopping_basket.core.{Item, Price}

import scala.collection.immutable.HashMap

/**
 * Represents a database of items available in the shop
 */
object ItemsDB {

  private lazy val map: HashMap[String, Item] = collection.immutable.HashMap(
    "soup" -> Item("Soup", Price(65)),
    "bread" -> Item("Bread", Price(80)),
    "milk" -> Item("Milk", Price(130)),
    "apples" -> Item("Apples", Price(100))
  )

  def getItem(name : String) : Option[Item] = map.get(name)


}
