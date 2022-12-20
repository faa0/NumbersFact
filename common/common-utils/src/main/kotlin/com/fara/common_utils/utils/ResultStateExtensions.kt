package com.fara.common_utils.utils

fun <T> ResultState<T>.fold(
    onSuccess: (data: T) -> Unit,
    onError: (code: Int, message: String) -> Unit = { _, _ -> },
    onFailure: (exception: Throwable) -> Unit = {},
) {
    when (this) {
        is ResultState.Success -> onSuccess(this.data)
        is ResultState.Error -> onError(this.code, this.message)
        is ResultState.Failure -> onFailure(this.exception)
        is ResultState.Loading -> Unit
    }
}