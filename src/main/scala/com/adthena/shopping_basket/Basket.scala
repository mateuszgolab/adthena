package com.adthena.shopping_basket


class Basket(val items: List[Item]) {

  def getTotalCost: Long = {
    items.map(p => p.price).sum
  }


  def contains(itemsToCheck : List[Item]) : Boolean = {

    val itemsIntersection : List[Item] = items.intersect(itemsToCheck)
    itemsToCheck.diff(itemsIntersection).isEmpty

  }


}
