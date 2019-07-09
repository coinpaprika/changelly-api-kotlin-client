/*
 * Created by Piotr Kostecki on 4/23/19 11:48 AM
 */

package com.coinpaprika.changellyapiclient.api

import android.content.Context
import android.net.ConnectivityManager

abstract class BaseApi(private val context: Context) {
    fun isThereInternetConnection(): Boolean {
        var isConnected = true

        if (this.context.getSystemService(Context.CONNECTIVITY_SERVICE) != null) {
            val connectivityManager = this.context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting
        }

        return isConnected
    }
}