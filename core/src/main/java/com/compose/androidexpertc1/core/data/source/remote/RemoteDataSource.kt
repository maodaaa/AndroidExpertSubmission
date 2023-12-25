package com.compose.androidexpertc1.core.data.source.remote

import com.compose.androidexpertc1.core.data.mappers.DataMapper.toDomain
import com.compose.androidexpertc1.core.data.mappers.DataMapper.toMovieDetail
import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.data.source.remote.network.ApiService
import com.compose.androidexpertc1.core.domain.model.Movie
import com.compose.androidexpertc1.core.domain.model.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getMovies(): Flow<Resource<List<Movie>?>> = flow {
        try {
            emit(Resource.Loading)
            val response = apiService.getMovies()
            if (response.isSuccessful) {
                val movies = response.body()?.results
                emit(Resource.Success(movies?.map { it.toDomain() }))
            } else {
                emit(Resource.Error(Exception("Failed to fetch movies")))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getDetailMovie(id: Int): Flow<Resource<MovieDetail?>> = flow {
        try {
            emit(Resource.Loading)
            val response = apiService.getDetailMovie(id)
            if (response.isSuccessful) {
                val movie = response.body()
                emit(Resource.Success(movie?.toMovieDetail()))
            } else {
                emit(Resource.Error(Exception("Failed to fetch movie details")))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun searchMovie(query: String): Flow<Resource<List<Movie>?>> = flow {
        try {
            emit(Resource.Loading)
            val response = apiService.searchMovie(query)
            if (response.isSuccessful) {
                val movies = response.body()?.results
                emit(Resource.Success(movies?.map { it.toDomain() }))
            } else {
                emit(Resource.Error(Exception("Failed to search movies")))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }.flowOn(Dispatchers.IO)

}