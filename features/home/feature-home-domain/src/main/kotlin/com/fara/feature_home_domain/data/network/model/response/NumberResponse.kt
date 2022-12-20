package com.fara.feature_home_domain.data.network.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NumberResponse(

    @Json(name = "number")
    val number: Int,

    @Json(name = "text")
    val text: String
)