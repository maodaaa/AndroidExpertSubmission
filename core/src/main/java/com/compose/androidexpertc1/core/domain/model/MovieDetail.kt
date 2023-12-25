package com.compose.androidexpertc1.core.domain.model

data class MovieDetail(
    val id: Int,
    val imdbId: String? = null,
    val title: String,
    val backdropPath: String? = null,
    val genres: List<Genre>,
    val overview: String,
    val runtime: Int? = null,
    val posterPath: String,
    val releaseDate: String? = null,
    val voteAverage: Double? = null,
    val status: String? = null,
)
