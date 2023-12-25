package com.compose.androidexpertc1.core.data.source.remote.network

import com.compose.androidexpertc1.core.data.source.remote.model.detail.DetailMovieResult
import com.compose.androidexpertc1.core.data.source.remote.model.movie.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/now_playing")
    suspend fun getMovies(): Response<MoviesResponse>

    @GET("movie/{id}")
    suspend fun getDetailMovie(@Path("id") id: Int): Response<DetailMovieResult>

    @GET("search/movie")
    suspend fun searchMovie(@Query("query") query: String): Response<MoviesResponse>
}