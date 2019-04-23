/*
 * Created by Piotr Kostecki on 4/23/19 1:00 PM
 */

package com.coinpaprika.changellyapiclient.extensions

import java.security.MessageDigest

fun String.hmac(): String {
    val bytes = this.toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}