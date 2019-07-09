/*
 * Created by Piotr Kostecki on 4/23/19 11:28 AM
 */

package com.coinpaprika.changellyapiclient.api

import android.content.Context
import com.coinpaprika.changellyapiclient.extensions.safeApiCallRaw
import com.coinpaprika.changellyapiclient.model.JsonRpcRequest
import com.coinpaprika.changellyapiclient.model.JsonRpcResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import java.math.BigDecimal

class ChangellyApi constructor(
    context: Context,
    private var retrofit: ChangellyApiContract = ChangellyApiFactory().client().create(ChangellyApiContract::class.java)
) : BaseApi(context), ChangellyApiContract {

    override fun getCurrencies(request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return safeApiCallRaw { retrofit.getCurrencies() }
    }

    override fun getCurrenciesFull(@Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return safeApiCallRaw { retrofit.getCurrenciesFull() }
    }

    override fun getMinAmount(
        from: String,
        to: String,
        request: JsonRpcRequest
    ): Observable<Response<JsonRpcResponse>> {
        return safeApiCallRaw { retrofit.getMinAmount(from, to) }
    }

    override fun getExchangeAmount(
        from: String,
        to: String,
        amount: BigDecimal,
        request: JsonRpcRequest
    ): Observable<Response<JsonRpcResponse>> {
        return safeApiCallRaw { retrofit.getExchangeAmount(from, to, amount) }
    }

    override fun createTransaction(
        from: String,
        to: String,
        amount: BigDecimal,
        address: String,
        extraId: String?,
        refundAddress: String?,
        refundExtraId: String?,
        @Body request: JsonRpcRequest
    ): Observable<Response<JsonRpcResponse>> {
        return safeApiCallRaw { retrofit.createTransaction(from, to, amount, address, extraId, refundAddress, refundExtraId) }
    }

    override fun getTransaction(
        currency: String?,
        address: String?,
        extraId: String?,
        limit: Int?,
        offset: Int?,
        @Body request: JsonRpcRequest
    ): Observable<Response<JsonRpcResponse>> {
        return safeApiCallRaw { retrofit.getTransaction(currency, address, extraId, limit, offset) }
    }

    override fun getStatus(id: String, request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return safeApiCallRaw { retrofit.getStatus(id) }
    }
}