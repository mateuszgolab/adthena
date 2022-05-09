package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Basket, Item, Price}

/**
 * Represents a special offer where multiple items are involved
 *
 * @param name               name of the offer
 * @param requiredItems      items required for the offer to apply
 * @param discountedItem    item to be discounted as a result of this offer
 * @param discountPercentage discount represented as a percentage e.g. 10 means 10% discount
 */
class MultiOffer(val name: String, val requiredItems: List[Item], val discountedItem: Item, discountPercentage: Int)  extends Offer {

  val priceDiscount: Price = Price(discountedItem.price.value * discountPercentage / 100)

  override def toString: String = name +": " + priceDiscount

  override def isApplicable(basket: Basket): Boolean = basket.contains(requiredItems) && basket.contains(discountedItem)

}

