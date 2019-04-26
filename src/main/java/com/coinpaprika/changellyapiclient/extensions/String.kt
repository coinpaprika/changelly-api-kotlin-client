/*
 * Created by Piotr Kostecki on 4/23/19 1:00 PM
 */

package com.coinpaprika.changellyapiclient.extensions

import com.coinpaprika.changellyapiclient.BuildConfig
import org.apache.commons.codec.binary.Hex
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun String.hmac(): String {
    val algorithm = "HmacSHA512"
    val charsetName = "UTF-8"
    val sha256HMAC = Mac.getInstance(algorithm)
    val secretKey = SecretKeySpec(BuildConfig.API_SECRET.toByteArray(charset(charsetName)), algorithm)
    sha256HMAC.init(secretKey)

    return Hex.encodeHexString(sha256HMAC.doFinal(this.toByteArray(charset(charsetName))))
}