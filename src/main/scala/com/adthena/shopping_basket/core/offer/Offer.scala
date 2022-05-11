package com.adthena.shopping_basket.core.offer

import com.adthena.shopping_basket.core.{Basket, Price}

trait Offer {

  /**
   * name of the offer
   */
  val name : String

  /**
   * offer discount represented as a Price
   */
  val priceDiscount : Price

  /**
   *
   * @param basket basket to check the offer against
   * @return true/false if an offer is applicable for a given basket
   */
  def isApplicable(basket : Basket) : Boolean

}
