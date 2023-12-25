package com.compose.androidexpertc1.core.domain.repository

import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.domain.model.Movie
import com.compose.androidexpertc1.core.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface IMoviesRepository {

    fun getAllFavoriteMovies(): Flow<Resource<List<Movie>?>>

    suspend fun addFavoriteMovie(movie: MovieDetail): Resource<Unit>

    suspend fun removeFavoriteMovie(movie: MovieDetail): Resource<Unit>

    fun isMovieFavorite(movieId: Int): Flow<Boolean>

    suspend fun getMovies(): Flow<Resource<List<Movie>?>>

    suspend fun getDetailMovie(id: Int): Flow<Resource<MovieDetail?>>

    suspend fun searchMovie(query: String): Flow<Resource<List<Movie>?>>


}