package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Basket, Item}

/**
 * Represents a simple special offer where a single item is discounted
 *
 * @param name               name of the offer
 * @param item               single item to be discounted as part of this offer
 * @param discountPercentage discount represented as a percentage e.g. 10 means 10% discount
 */
class SimpleDiscountOffer(name: String, item: Item, discountPercentage: Int)
  extends MultiOffer(name, List(item), item, discountPercentage) {

  override def toString: String = item.name + " " + discountPercentage + "% off: " + priceDiscount

  override def isApplicable(basket: Basket): Boolean = basket.contains(item)

}


