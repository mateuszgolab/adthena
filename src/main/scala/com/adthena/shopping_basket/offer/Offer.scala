package com.adthena.shopping_basket.offer

import com.adthena.shopping_basket.Item


class Offer(val name: String, val requiredItems: List[Item], val discountedItems: List[Item],  discountPercentage: Int) {

  val discountValue: Long = discountedItems.map(i => (i.price * discountPercentage) / 100).sum

}

