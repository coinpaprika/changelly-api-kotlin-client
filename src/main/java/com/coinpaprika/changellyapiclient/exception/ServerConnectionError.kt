/*
 * Created by Piotr Kostecki on 4/23/19 11:54 AM
 */

package com.coinpaprika.changellyapiclient.exception

class ServerConnectionError : Exception {
    constructor() : super()
    constructor(cause: Throwable) : super(cause)
}