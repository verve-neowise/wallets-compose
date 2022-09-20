package io.neowise.walletscompose.remote

import java.lang.Exception

sealed class Response<out T> {
    object Loading: Response<Nothing>()
    data class Success<out T>(val data: T) : Response<T>()
    data class Failure<out T>(val exception: Exception) : Response<T>()
}