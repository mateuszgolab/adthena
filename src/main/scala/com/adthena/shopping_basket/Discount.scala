package com.adthena.shopping_basket

import com.adthena.shopping_basket.offer.Offer


class Discount(val discountValue: Long, val offersApplied: List[Offer])

object Discount {

  def evaluate(basket: Basket, offers: List[Offer]): Discount = {

    def isOfferApplicable(basket: Basket, offer: Offer): Boolean = {
      basket.contains(offer.requiredItems) && basket.contains(offer.discountedItems)
    }

    val applicableOffers = offers.filter(o => isOfferApplicable(basket, o))

    if (applicableOffers.nonEmpty) {

      val totalDiscount = applicableOffers.map(_.discountValue).sum
      new Discount(totalDiscount, applicableOffers)

    } else {

      NoDiscount()
    }

  }


}
