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
   *
   * @param tryItems list parsed items
   */
  def this(tryItems: Array[Try[Item]]) = {
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
   * @param item and item to be counted in the basket
   * @return number of occurrences of a given item in the basket
   */
  def count(item: Item): Int = items.count(_.equals(item))

}
