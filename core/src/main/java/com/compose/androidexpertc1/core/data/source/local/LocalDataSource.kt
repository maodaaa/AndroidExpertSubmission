package com.compose.androidexpertc1.core.data.source.local

import com.compose.androidexpertc1.core.data.mappers.DataMapper.toMovie
import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.data.source.local.dao.MoviesDao
import com.compose.androidexpertc1.core.data.source.local.entity.MovieEntity
import com.compose.androidexpertc1.core.domain.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val moviesDao: MoviesDao,
) {

    fun getAllFavoriteMovies(): Flow<Resource<List<Movie>?>> = flow {
        emit(Resource.Loading)
        try {
            val moviesEntity = moviesDao.getAllFavoriteMovies().firstOrNull()
            val movie = moviesEntity?.map { movieEntity -> movieEntity.toMovie() }
            emit(Resource.Success(movie))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }.flowOn(Dispatchers.IO)


    fun isMovieFavorite(movieId: Int): Flow<Boolean> = flow {
        val movie = moviesDao.isMovieFavorite(movieId).first()
        emit(movie)
    }.flowOn(Dispatchers.IO)


    suspend fun addFavoriteMovie(movie: MovieEntity): Resource<Unit> {
        Resource.Loading
        return try {
            val addMovie = movie.copy(isFavorite = true)
            moviesDao.addFavoriteMovie(addMovie)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e)
        }

    }

    suspend fun removeFavoriteMovie(movie: MovieEntity): Resource<Unit> {
        Resource.Loading
        return try {
            moviesDao.removeFavoriteMovie(movie)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e)
        }

    }

}