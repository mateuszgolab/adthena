package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Basket, Item}

/**
 * Represents a special offer where multiple items of the same type give discount to another item
 *
 * @param name               name of the offer
 * @param requiredItems      map of required item and required minimal number of it for the multi offer to apply
 * @param discountedItem     item to be discounted as a result of this offer
 * @param discountPercentage discount represented as a percentage e.g. 10 means 10% discount
 */
class MultiOffer(name: String, val requiredItems: Map[Item, Int], discountedItem: Item, discountPercentage: Int)
  extends PercentageOffer(name, discountedItem, discountPercentage) {

  /**
   * If an offer requires N occurrences of an item in the basket for it to apply
   * Count number of all occurrences in the basket and divide by N to get the number of times this offer can apply
   * on a given basket
   *
   * @param basket basket to check the offer against
   * @return number of times an offer can be applied for a given basket
   */
  override def getApplicationsCount(basket: Basket): Int = {
    val requiredItemsCount: Int = requiredItems.map(req => basket.count(req._1) / req._2).min
    val discountedItemsCount = basket.count(discountedItem)

    Math.min(requiredItemsCount, discountedItemsCount)

  }

}

