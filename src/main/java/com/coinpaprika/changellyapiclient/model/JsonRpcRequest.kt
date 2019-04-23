/*
 * Created by Piotr Kostecki on 4/23/19 11:35 AM
 */

package com.coinpaprika.changellyapiclient.model

data class JsonRpcRequest(
    val jsonrpc: String = "2.0",
    val method: String,
    val params: Map<Any, Any?> = mapOf(),
    val id: Long = System.currentTimeMillis()
)