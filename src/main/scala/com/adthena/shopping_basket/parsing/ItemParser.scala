package com.adthena.shopping_basket.parsing

import com.adthena.shopping_basket.core.Item
import com.adthena.shopping_basket.data.ItemsDB

import scala.util.{Failure, Success, Try}

/**
 * Shopping items parser
 */
object ItemParser {

  /**
   * @param input items names as an array of strings
   * @return array of Try[Item]
   */
  def parseItems(input: Array[String]): Array[Try[Item]] = {

    input.map(in => ItemsDB.getItem(in.toLowerCase()) match {
      case Some(item) => Success(item)
      case None => Failure(new Exception("Item: '" + in + "' not found"))
    })

  }

}
