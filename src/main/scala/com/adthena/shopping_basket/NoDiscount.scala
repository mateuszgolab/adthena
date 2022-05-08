package com.adthena.shopping_basket

/**
 * Used when there are no offers applied
 */
case class NoDiscount() extends Discount(0, List.empty)

