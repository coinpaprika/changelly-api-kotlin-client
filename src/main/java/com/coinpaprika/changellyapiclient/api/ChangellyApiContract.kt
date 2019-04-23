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


interface ChangellyApiContract {
    @POST("")
    fun getCurrencies(@Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun getCurrenciesFull(@Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun getMinAmount(@Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun getExchangeAmount(@Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun createTransaction(@Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun getTransaction(@Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>>

    @POST("")
    fun getStatus(@Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>>
}