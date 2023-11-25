package com.fara.common_network.utils

suspend fun <T> safeApiCall(call: suspend () -> Result<T>): Result<T> {
    return try {
        call()
    } catch (ex: Exception) {
        Result.failure(ex)
    }
}