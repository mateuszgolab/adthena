package com.adthena.shopping_basket.core

import com.adthena.shopping_basket.core.offer.Offer

/**
 * Represents a discount applied for a given basket with a given offers
 *
 * @param priceDiscount price discount represented as a price object
 * @param applicableOffers applicable offers for a given basket
 */
class Discount(val priceDiscount: Price, val applicableOffers: List[Offer])

object Discount {

  /**
   * @param basket shopping basket
   * @param offers available offers
   * @return total discount from all the offers and the offers applied to a given basket
   */
  def evaluate(basket: Basket, offers: List[Offer]): Discount = {

    val applicableOffers = offers.filter(_.isApplicable(basket))
    val totalDiscount = applicableOffers.map(_.priceDiscount.value).sum

    new Discount(Price(totalDiscount), applicableOffers)

  }


}
