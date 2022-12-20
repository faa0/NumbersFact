package com.fara.common_utils.utils

sealed class ResultState<out T> {
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val code: Int, val message: String) : ResultState<Nothing>()
    data class Failure(val exception: Throwable) : ResultState<Nothing>()
    data class Loading(val state: Boolean) : ResultState<Nothing>()
}