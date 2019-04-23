/*
 * Created by Piotr Kostecki on 4/23/19 11:28 AM
 */

package com.coinpaprika.changellyapiclient.api

import android.content.Context
import com.coinpaprika.changellyapiclient.exception.NetworkConnectionException
import com.coinpaprika.changellyapiclient.exception.ServerConnectionError
import com.coinpaprika.changellyapiclient.model.JsonRpcRequest
import com.coinpaprika.changellyapiclient.model.JsonRpcResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import java.math.BigDecimal

class ChangellyApi constructor(context: Context,
                               private var retrofit: ChangellyApiContract = ChangellyApiFactory().client().create(ChangellyApiContract::class.java))
: BaseApi(context), ChangellyApiContract {

    override fun getCurrencies(request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return Observable.create { emitter ->
            if (isThereInternetConnection()) {
                try {
                    retrofit.getCurrencies()
                        .doOnNext {
                            if (!emitter.isDisposed) {
                                if (it.isSuccessful) {
                                    emitter.onNext(it)
                                    emitter.onComplete()
                                } else {
                                    emitter.onError(ServerConnectionError())
                                }
                            }
                        }
                        .doOnComplete { if (!emitter.isDisposed) emitter.onComplete() }
                        .doOnError { if (!emitter.isDisposed) emitter.onError(it) }
                        .subscribe({}, {error -> error.printStackTrace()})
                } catch (e: Exception) {
                    e.printStackTrace()
                    emitter.onError(NetworkConnectionException(e.cause))
                }
            } else {
                emitter.onError(NetworkConnectionException())
            }
        }
    }

    override fun getCurrenciesFull(@Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return Observable.create { emitter ->
            if (isThereInternetConnection()) {
                try {
                    retrofit.getCurrenciesFull()
                        .doOnNext {
                            if (!emitter.isDisposed) {
                                if (it.isSuccessful) {
                                    emitter.onNext(it)
                                    emitter.onComplete()
                                } else {
                                    emitter.onError(ServerConnectionError())
                                }
                            }
                        }
                        .doOnComplete { if (!emitter.isDisposed) emitter.onComplete() }
                        .doOnError { if (!emitter.isDisposed) emitter.onError(it) }
                        .subscribe({}, {error -> error.printStackTrace()})
                } catch (e: Exception) {
                    e.printStackTrace()
                    emitter.onError(NetworkConnectionException(e.cause))
                }
            } else {
                emitter.onError(NetworkConnectionException())
            }
        }
    }

    override fun getMinAmount(from: String, to: String, request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return Observable.create { emitter ->
            if (isThereInternetConnection()) {
                try {
                    retrofit.getMinAmount(from, to)
                        .doOnNext {
                            if (!emitter.isDisposed) {
                                if (it.isSuccessful) {
                                    emitter.onNext(it)
                                    emitter.onComplete()
                                } else {
                                    emitter.onError(ServerConnectionError())
                                }
                            }
                        }
                        .doOnComplete { if (!emitter.isDisposed) emitter.onComplete() }
                        .doOnError { if (!emitter.isDisposed) emitter.onError(it) }
                        .subscribe({}, {error -> error.printStackTrace()})
                } catch (e: Exception) {
                    e.printStackTrace()
                    emitter.onError(NetworkConnectionException(e.cause))
                }
            } else {
                emitter.onError(NetworkConnectionException())
            }
        }
    }

    override fun getExchangeAmount(from: String, to: String, amount: BigDecimal, request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return Observable.create { emitter ->
            if (isThereInternetConnection()) {
                try {
                    retrofit.getExchangeAmount(from, to, amount)
                        .doOnNext {
                            if (!emitter.isDisposed) {
                                if (it.isSuccessful) {
                                    emitter.onNext(it)
                                    emitter.onComplete()
                                } else {
                                    emitter.onError(ServerConnectionError())
                                }
                            }
                        }
                        .doOnComplete { if (!emitter.isDisposed) emitter.onComplete() }
                        .doOnError { if (!emitter.isDisposed) emitter.onError(it) }
                        .subscribe({}, {error -> error.printStackTrace()})
                } catch (e: Exception) {
                    e.printStackTrace()
                    emitter.onError(NetworkConnectionException(e.cause))
                }
            } else {
                emitter.onError(NetworkConnectionException())
            }
        }
    }

    override fun createTransaction(from: String,
                                   to: String,
                                   amount: BigDecimal,
                                   address: String,
                                   extraId: String?,
                                   refundAddress: String?,
                                   refundExtraId: String?,
                                   @Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return Observable.create { emitter ->
            if (isThereInternetConnection()) {
                try {
                    retrofit.createTransaction(from, to, amount, address, extraId, refundAddress, refundExtraId)
                        .doOnNext {
                            if (!emitter.isDisposed) {
                                if (it.isSuccessful) {
                                    emitter.onNext(it)
                                    emitter.onComplete()
                                } else {
                                    emitter.onError(ServerConnectionError())
                                }
                            }
                        }
                        .doOnComplete { if (!emitter.isDisposed) emitter.onComplete() }
                        .doOnError { if (!emitter.isDisposed) emitter.onError(it) }
                        .subscribe({}, {error -> error.printStackTrace()})
                } catch (e: Exception) {
                    e.printStackTrace()
                    emitter.onError(NetworkConnectionException(e.cause))
                }
            } else {
                emitter.onError(NetworkConnectionException())
            }
        }
    }

    override fun getTransaction(currency: String?,
                                address: String?,
                                extraId: String?,
                                limit: Int?,
                                offset: Int?,
                                @Body request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return Observable.create { emitter ->
            if (isThereInternetConnection()) {
                try {
                    retrofit.getTransaction(currency, address, extraId, limit, offset)
                        .doOnNext {
                            if (!emitter.isDisposed) {
                                if (it.isSuccessful) {
                                    emitter.onNext(it)
                                    emitter.onComplete()
                                } else {
                                    emitter.onError(ServerConnectionError())
                                }
                            }
                        }
                        .doOnComplete { if (!emitter.isDisposed) emitter.onComplete() }
                        .doOnError { if (!emitter.isDisposed) emitter.onError(it) }
                        .subscribe({}, {error -> error.printStackTrace()})
                } catch (e: Exception) {
                    e.printStackTrace()
                    emitter.onError(NetworkConnectionException(e.cause))
                }
            } else {
                emitter.onError(NetworkConnectionException())
            }
        }
    }

    override fun getStatus(id: String, request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return Observable.create { emitter ->
            if (isThereInternetConnection()) {
                try {
                    retrofit.getStatus(id)
                        .doOnNext {
                            if (!emitter.isDisposed) {
                                if (it.isSuccessful) {
                                    emitter.onNext(it)
                                    emitter.onComplete()
                                } else {
                                    emitter.onError(ServerConnectionError())
                                }
                            }
                        }
                        .doOnComplete { if (!emitter.isDisposed) emitter.onComplete() }
                        .doOnError { if (!emitter.isDisposed) emitter.onError(it) }
                        .subscribe({}, {error -> error.printStackTrace()})
                } catch (e: Exception) {
                    e.printStackTrace()
                    emitter.onError(NetworkConnectionException(e.cause))
                }
            } else {
                emitter.onError(NetworkConnectionException())
            }
        }
    }
}