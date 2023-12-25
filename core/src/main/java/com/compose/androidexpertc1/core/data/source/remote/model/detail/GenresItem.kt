package com.compose.androidexpertc1.core.data.source.remote.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenresItem(

    @Json(name = "id") val id: Int,

    @Json(name = "name") val name: String,

    )