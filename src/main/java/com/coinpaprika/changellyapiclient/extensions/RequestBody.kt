/*
 * Created by Piotr Kostecki on 4/24/19 2:26 PM
 */

package com.coinpaprika.changellyapiclient.extensions

import okhttp3.RequestBody
import okio.Buffer
import java.lang.Exception

fun RequestBody?.string(): String {
    try {
        val copy = this
        val buffer = Buffer()
        if (copy != null) {
            copy.writeTo(buffer)
        } else {
            return ""
        }
        return buffer.readUtf8()
    } catch (e: Exception) {
        e.printStackTrace()
        return ""
    }
}