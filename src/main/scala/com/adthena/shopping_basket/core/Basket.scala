package com.adthena.shopping_basket.core

import scala.util.Try

/**
 * Represents a shopping basket
 *
 * @param items items added to the basket
 */
class Basket(val items: List[Item]) {

  /**
   * Auxiliary constructor
   * Only valid Items will be added to the basket
   * @param tryItems list parsed items
   */
  def this(tryItems : Array[Try[Item]]) = {
    this(tryItems.flatMap(_.toOption).toList)
  }

  /**
   *
   * @return total cost of all the items in the basket
   */
  def getTotalCost: Price = {

    val total = items.
      map(p => p.price.value).
      sum

    Price(total)

  }

  /**
   *
   * @param itemsToCheck list of items which presence in the basket is checked
   * @return true - if all the basket contains all the items, false - otherwise
   */
  def contains(itemsToCheck: List[Item]): Boolean = {

    val itemsIntersection: List[Item] = items.intersect(itemsToCheck)
    itemsToCheck.diff(itemsIntersection).isEmpty

  }

  /**
   *
   * @param item an item which presence in the basket is checked
   * @return true/false basket contains an item
   */
  def contains(item: Item): Boolean = items.contains(item)


}
