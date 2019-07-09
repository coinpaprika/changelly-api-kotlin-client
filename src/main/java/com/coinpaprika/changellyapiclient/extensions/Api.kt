/*
 * Created by Piotr Kostecki on 7/9/19 11:28 AM
 */

package com.coinpaprika.changellyapiclient.extensions

import com.coinpaprika.changellyapiclient.api.BaseApi
import com.coinpaprika.changellyapiclient.exception.NetworkConnectionException
import com.coinpaprika.changellyapiclient.exception.ServerConnectionError
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.disposables.Disposable
import retrofit2.Response
import java.lang.Exception

fun <T : Any> BaseApi.safeApiCallRaw(call: () -> Observable<Response<T>>): Observable<Response<T>> {
    return Observable.create {
        if (!this.isThereInternetConnection()) {
            it.onError(NetworkConnectionException())
            return@create
        }
        try {
            call().handleResponse(it)
        } catch (e: Exception) {
            it.onError(NetworkConnectionException(e.cause))
        }
    }
}

fun <T> Observable<Response<T>>.handleResponse(emitter: ObservableEmitter<Response<T>>): Disposable {
    return this.doOnNext {
        if (emitter.isDisposed) return@doOnNext
        if (it.isSuccessful && it.body() != null) {
            emitter.onNext(it)
        } else {
            emitter.onError(ServerConnectionError())
        }
    }
        .doOnComplete { if (!emitter.isDisposed) emitter.onComplete() }
        .doOnError { if (!emitter.isDisposed) emitter.onError(it) }
        .subscribe({}, { error -> error.printStackTrace() })
}