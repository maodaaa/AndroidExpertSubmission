package com.compose.androidexpertc1.core.data.repository


import com.compose.androidexpertc1.core.data.mappers.DataMapper.toMovieEntity
import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.data.source.local.LocalDataSource
import com.compose.androidexpertc1.core.data.source.remote.RemoteDataSource
import com.compose.androidexpertc1.core.domain.model.Movie
import com.compose.androidexpertc1.core.domain.model.MovieDetail
import com.compose.androidexpertc1.core.domain.repository.IMoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : IMoviesRepository {


    override fun getAllFavoriteMovies(): Flow<Resource<List<Movie>?>> {
        return localDataSource.getAllFavoriteMovies()
    }

    override fun isMovieFavorite(movieId: Int): Flow<Boolean> {
        return localDataSource.isMovieFavorite(movieId)
    }

    override suspend fun addFavoriteMovie(movie: MovieDetail): Resource<Unit> {
        return localDataSource.addFavoriteMovie(movie.toMovieEntity())
    }

    override suspend fun removeFavoriteMovie(movie: MovieDetail): Resource<Unit> {
        return localDataSource.removeFavoriteMovie(movie.toMovieEntity())
    }

    override suspend fun getMovies(): Flow<Resource<List<Movie>?>> {
        return remoteDataSource.getMovies()
    }

    override suspend fun getDetailMovie(id: Int): Flow<Resource<MovieDetail?>> {
        return remoteDataSource.getDetailMovie(id)
    }

    override suspend fun searchMovie(query: String): Flow<Resource<List<Movie>?>> {
        return remoteDataSource.searchMovie(query)
    }
}
