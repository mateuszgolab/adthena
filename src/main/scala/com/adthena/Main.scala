package com.adthena

import com.adthena.shopping_basket.core.Discount
import com.adthena.shopping_basket.data.OffersDB
import com.adthena.shopping_basket.parsing.BasketParser
import com.adthena.shopping_basket.view.CommandLineView

object Main {

  def main(args: Array[String]): Unit = {

    val basket = BasketParser.parseItems(args)
    val discount = Discount.evaluate(basket, OffersDB.getAll)

    CommandLineView.show(basket, discount)

  }



}
