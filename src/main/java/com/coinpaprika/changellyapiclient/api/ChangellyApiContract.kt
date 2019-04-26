/*
 * Created by Piotr Kostecki on 4/23/19 11:28 AM
 */

package com.coinpaprika.changellyapiclient.api

import com.coinpaprika.changellyapiclient.model.JsonRpcRequest
import com.coinpaprika.changellyapiclient.model.JsonRpcResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import java.math.BigDecimal

interface ChangellyApiContract {
    @POST("/")
    fun getCurrencies(@Body request: JsonRpcRequest = JsonRpcRequest(method = "getCurrencies")): Observable<Response<JsonRpcResponse>>

    @POST("/")
    fun getCurrenciesFull(@Body request: JsonRpcRequest = JsonRpcRequest(method = "getCurrenciesFull")): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun getMinAmount(
        from: String,
        to: String,
        @Body request: JsonRpcRequest = JsonRpcRequest(
            method = "getMinAmount",
            params = mapOf(
                Pair("from", from),
                Pair("to", to)
            )
        )
    ): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun getExchangeAmount(
        from: String,
        to: String,
        amount: BigDecimal,
        @Body request: JsonRpcRequest = JsonRpcRequest(
            method = "getExchangeAmount",
            params = mapOf(
                Pair("from", from),
                Pair("to", to),
                Pair("amount", amount)
            )
        )
    ): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun createTransaction(
        from: String,
        to: String,
        amount: BigDecimal,
        address: String,
        extraId: String? = null,
        refundAddress: String? = null,
        refundExtraId: String? = null,
        @Body request: JsonRpcRequest = JsonRpcRequest(
            method = "createTransaction",
            params = mapOf(
                Pair("from", from),
                Pair("to", to),
                Pair("amount", amount),
                Pair("address", address),
                Pair("extraId", extraId),
                Pair("refundAddress", refundAddress),
                Pair("refundExtraId", refundExtraId)
            )
        )
    ): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun getTransaction(
        currency: String? = null,
        address: String? = null,
        extraId: String? = null,
        limit: Int? = null,
        offset: Int? = null,
        @Body request: JsonRpcRequest = JsonRpcRequest(
            method = "getTransaction",
            params = mapOf(
                Pair("currency", currency),
                Pair("address", address),
                Pair("extraId", extraId),
                Pair("limit", limit),
                Pair("offset", offset)
            )
        )
    ): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun getStatus(
        id: String,
        @Body request: JsonRpcRequest = JsonRpcRequest(
            method = "getStatus",
            params = mapOf(
                Pair("id", id)
            )
        )
    ): Observable<Response<JsonRpcResponse>>
}