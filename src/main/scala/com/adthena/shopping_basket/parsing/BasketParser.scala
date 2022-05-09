package com.adthena.shopping_basket.parsing

import com.adthena.shopping_basket.core.Basket
import com.adthena.shopping_basket.data.ItemsDB

/**
 * Parses item names into a Basket object
 */
object BasketParser {

  // TODO : add notify about invalid items
  def parseItems(input : Array[String]) : Basket = {

    val items =  input.
      flatMap(in => ItemsDB.getItem(in.toLowerCase())).
      toList

    new Basket(items)

  }

}
