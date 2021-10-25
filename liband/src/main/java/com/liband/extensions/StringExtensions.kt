package com.liband.extensions

import java.text.DecimalFormat

fun String.toBaseCurrencyFormat(
    decimalFormatPattern: String = "###,###,###.##",
    minimumFractionDigits: Int = 2
): String {
    val decimalFormat = DecimalFormat(decimalFormatPattern)
    decimalFormat.minimumFractionDigits = minimumFractionDigits
    return decimalFormat.format(this)
}