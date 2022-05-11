package com.adthena.shopping_basket.view

import com.adthena.shopping_basket.core.{Basket, Discount, Item, Price}

import scala.util.Try

/**
 * Provides command line output for shopping basket, offers and discounts
 */
object CommandLineView {

  /**
   * display in the command line
   * - the price of the basket before and after applying the offers
   * - the details of the offers applied
   *
   * @param basket shopping basket
   * @param discount discount object
   */
  def show(basket: Basket, discount: Discount): Unit = {

    System.out.println("Subtotal: " + basket.getTotalCost)

    if (discount.applicableOffers.isEmpty) {
      System.out.println("(No offers available)")
    } else {
      discount.applicableOffers.foreach(offer => System.out.println(offer))
    }

    val totalPrice = basket.getTotalCost.value - discount.priceDiscount.value
    System.out.println("Total price: " + Price(totalPrice))

  }

  /**
   * display in the command line invalid shopping items
   * @param list list of parsed items
   */
  def showInvalidItems(list: Array[Try[Item]]): Unit = {

    list.
      filter(_.isFailure).
      foreach(item => System.out.println(item.failed.get.getMessage))

  }

}
