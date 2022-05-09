package com.adthena.shopping_basket.view

import com.adthena.shopping_basket.core.{Basket, Discount, Price}

object CommandLineView {

  def show(basket: Basket, discount: Discount): Unit = {

    System.out.println("Subtotal: " + basket.getTotalCost)

    if (discount.offersApplied.isEmpty) {
      System.out.println("(No offers available)")
    } else {
      discount.offersApplied.foreach(offer => System.out.println(offer))
    }

    val totalPrice = basket.getTotalCost.value - discount.priceDiscount.value
    System.out.println("Total price: " + Price(totalPrice))

  }

}
