package com.adthena

import com.adthena.shopping_basket.core.{Basket, Discount}
import com.adthena.shopping_basket.data.OffersDB
import com.adthena.shopping_basket.parsing.ItemParser
import com.adthena.shopping_basket.view.CommandLineView

object Main extends App {

  val tryItems = ItemParser.parseItems(args)
  CommandLineView.showInvalidItems(tryItems)

  val basket = new Basket(tryItems)
  val discount = Discount.evaluate(basket, OffersDB.getCurrentOffers)

  CommandLineView.show(basket, discount)


}
