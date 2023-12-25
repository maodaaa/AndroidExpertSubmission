package com.compose.androidexpertc1.core.data.mappers

import com.compose.androidexpertc1.core.data.source.local.entity.GenreEntity
import com.compose.androidexpertc1.core.data.source.local.entity.MovieEntity
import com.compose.androidexpertc1.core.data.source.remote.model.detail.DetailMovieResult
import com.compose.androidexpertc1.core.data.source.remote.model.detail.GenresItem
import com.compose.androidexpertc1.core.data.source.remote.model.movie.MoviesResult
import com.compose.androidexpertc1.core.domain.model.Genre
import com.compose.androidexpertc1.core.domain.model.Movie
import com.compose.androidexpertc1.core.domain.model.MovieDetail


object DataMapper {
    fun MovieEntity.toMovie(): Movie {
        return Movie(
            id = id,
            title = title,
            posterPath = posterPath,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            isFavorite = isFavorite
        )
    }

    fun MoviesResult.toDomain(): Movie {
        return Movie(
            id = id,
            title = title,
            posterPath = posterPath,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            isFavorite = false
        )
    }

    fun DetailMovieResult.toMovieDetail(): MovieDetail {
        return MovieDetail(
            id = id,
            imdbId = imdbId,
            title = title,
            backdropPath = backdropPath,
            genres = genres.map { it.toGenre() },
            overview = overview,
            runtime = runtime,
            posterPath = posterPath,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            status = status
        )
    }

    fun MovieDetail.toMovieEntity(): MovieEntity {
        return MovieEntity(
            id = id,
            title = title,
            posterPath = posterPath,
            releaseDate = releaseDate,
            voteAverage = voteAverage,
            isFavorite = false
        )
    }


    private fun GenresItem.toGenre(): Genre {
        return Genre(
            id = id,
            name = name
        )
    }
}
