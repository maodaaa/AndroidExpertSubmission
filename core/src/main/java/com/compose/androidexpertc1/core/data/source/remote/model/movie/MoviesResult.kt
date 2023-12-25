package com.compose.androidexpertc1.core.data.source.remote.model.movie

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResult(
    @Json(name = "title")
    val title: String,

    @Json(name = "poster_path")
    val posterPath: String,

    @Json(name = "release_date")
    val releaseDate: String? = null,

    @Json(name = "vote_average")
    val voteAverage: Double? = null,

    @Json(name = "id")
    val id: Int,
)