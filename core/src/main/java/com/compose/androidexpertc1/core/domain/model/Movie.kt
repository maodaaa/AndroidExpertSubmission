package com.compose.androidexpertc1.core.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val posterPath: String,
    val releaseDate: String? = null,
    val voteAverage: Double? = null,
    val isFavorite: Boolean = false,
)