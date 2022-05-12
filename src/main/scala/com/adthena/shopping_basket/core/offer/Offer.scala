package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Basket, Price}

trait Offer {

  /**
   * name of the offer
   */
  val name: String

  /**
   * offer discount represented as a Price
   */
  val priceDiscount: Price


  /**
   *
   * @param basket basket to check the offer against
   * @return sum of all the discounts from a given offer on a given basket as a Price
   */
  def getTotalDiscount(basket: Basket): Price


}
