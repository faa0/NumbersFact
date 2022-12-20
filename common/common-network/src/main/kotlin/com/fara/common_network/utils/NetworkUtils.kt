package com.fara.common_network.utils

import com.fara.common_utils.utils.ResultState
import retrofit2.HttpException

suspend fun <T> safeApiCall(call: suspend () -> ResultState<T>): ResultState<T> {
    return try {
        call()
    } catch (ex: Exception) {
        return when (ex) {
            is HttpException -> ResultState.Error(ex.code(), ex.message())
            else -> ResultState.Failure(ex)
        }
    }
}