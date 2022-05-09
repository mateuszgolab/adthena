package com.adthena.shopping_basket.core

/**
 * Price
 *
 * @param value price represented in pence
 */
case class Price(value: Long) {
  require(value >= 0, "price can't be a negative value")

  /**
   * @return price as a String
   *         represented in pence when value < 100 e.g. 90p.
   *         represented in pounds when value >= 100 e.g. £1.20
   */
  override def toString: String = {

    if (value >= 100) {

      val penceRemainder :String = value % 100 match {
        case 0 => "00"
        case n => n.toString
      }

      s"£" + value / 100 + "." + penceRemainder

    } else {

      s"" + value % 100 + "p"
    }

  }

}

