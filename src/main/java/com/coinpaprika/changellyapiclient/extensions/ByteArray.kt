/*
 * Created by Piotr Kostecki on 5/13/19 3:56 PM
 */

package com.coinpaprika.changellyapiclient.extensions

import java.math.BigInteger


fun ByteArray.hexToString(): String {
    val bigInteger = BigInteger(1, this)
    return String.format(
        "%0" + (this.size shl 1) + "x", bigInteger
    )
}