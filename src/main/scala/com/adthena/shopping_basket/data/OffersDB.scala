package com.adthena.shopping_basket.data

import com.adthena.shopping_basket.core.offer.{MultiOffer, Offer, SimpleDiscountOffer}

/**
 * Represents a database of offers available in the shop
 */
object OffersDB {

  private val soup = ItemsDB.getItem("soup")
  private val bread = ItemsDB.getItem("bread")
  private val apples = ItemsDB.getItem("apples")

  private lazy val list = List[Offer](
    new MultiOffer("Buy 2 tins of soup and get bread 50% off",
      List(soup, soup, bread).flatten,
      bread.get,
      50
    ),
    new SimpleDiscountOffer("Apples 10% off", apples.get, 10)
  )

  def getAll: List[Offer] = list


}