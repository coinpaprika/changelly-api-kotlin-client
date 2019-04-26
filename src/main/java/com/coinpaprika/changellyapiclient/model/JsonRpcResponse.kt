/*
 * Created by Piotr Kostecki on 4/23/19 11:35 AM
 */

package com.coinpaprika.changellyapiclient.model

data class JsonRpcResponse(val jsonrpc: String, val result: Any, val id: Long)