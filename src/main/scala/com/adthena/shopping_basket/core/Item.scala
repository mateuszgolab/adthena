package com.adthena.shopping_basket.core

/**
 * Represents an item in a shop
 *
 * @param name  name of the item
 * @param price price of an item
 */
case class Item(name: String, price: Price) {
  require(name != null && name.nonEmpty, "item must have a name")
  require(price != null, "item must have a price")
}
