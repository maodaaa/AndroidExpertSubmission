package com.compose.androidexpertc1.core.data.source.remote.model.detail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailMovieResult(

    @Json(name = "imdb_id") val imdbId: String? = null,

    @Json(name = "title") val title: String,

    @Json(name = "backdrop_path") val backdropPath: String? = null,

    @Json(name = "genres") val genres: List<GenresItem>,

    @Json(name = "id") val id: Int,

    @Json(name = "overview") val overview: String,

    @Json(name = "runtime") val runtime: Int? = null,

    @Json(name = "poster_path") val posterPath: String,

    @Json(name = "release_date") val releaseDate: String? = null,

    @Json(name = "vote_average") val voteAverage: Double? = null,

    @Json(name = "status") val status: String? = null,
)