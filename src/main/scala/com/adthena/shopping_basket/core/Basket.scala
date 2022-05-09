package com.adthena.shopping_basket.core

/**
 * Represents a shopping basket
 *
 * @param items items added to the basket
 */
class Basket(val items: List[Item]) {

  /**
   *
   * @return total cost of all the items in the basket
   */
  def getTotalCost: Price = {
    val total = items.map(p => p.price.value).sum
    Price(total)
  }

  def contains(itemsToCheck: List[Item]): Boolean = {

    val itemsIntersection: List[Item] = items.intersect(itemsToCheck)
    itemsToCheck.diff(itemsIntersection).isEmpty

  }

  def contains(item: Item): Boolean = items.contains(item)


}
