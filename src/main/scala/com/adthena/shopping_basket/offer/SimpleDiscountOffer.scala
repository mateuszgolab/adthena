package com.adthena.shopping_basket.offer

import com.adthena.shopping_basket.Item

class SimpleDiscountOffer(name: String, item: Item, discountPercentage: Int)
  extends Offer(name, List(item), List(item), discountPercentage)


