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

class ChangellyApi constructor(context: Context,
                               private var retrofit: ChangellyApiContract = ChangellyApiFactory().client().create(ChangellyApiContract::class.java))
: BaseApi(context), ChangellyApiContract {

    override fun getCurrencies(request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        return Observable.create { emitter ->
            if (isThereInternetConnection()) {
                try {
                    retrofit.getCurrencies(JsonRpcRequest(method = "getCurrencies"))
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

    override fun getCurrenciesFull(request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMinAmount(request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getExchangeAmount(request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createTransaction(request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTransaction(request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStatus(request: JsonRpcRequest): Observable<Response<JsonRpcResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}