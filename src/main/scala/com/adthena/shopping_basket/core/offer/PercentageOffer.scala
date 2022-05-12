package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Basket, Item, Price}

/**
 *
 * @param name name of the offer
 * @param discountedItem an item to be discounted in this offer
 * @param discountPercentage percentage discount of the offer represented as in e.g. 50% is represented as 50
 */
abstract class PercentageOffer(val name: String, val discountedItem: Item, discountPercentage: Int) extends Offer {

  /**
   *
   * @param basket basket to check the offer against
   * @return number of times an offer can be applied for a given basket
   */
  protected def getApplicationsCount(basket: Basket): Int


  override val priceDiscount: Price = Price(discountedItem.price.value * discountPercentage / 100)

  override def getTotalDiscount(basket: Basket): Price = Price(getApplicationsCount(basket) * priceDiscount.value)

}
