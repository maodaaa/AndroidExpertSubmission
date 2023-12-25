package com.compose.androidexpertc1.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.compose.androidexpertc1.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movies WHERE isFavorite == 1")
    fun getAllFavoriteMovies(): Flow<List<MovieEntity>?>

    @Query("SELECT * FROM movies WHERE id = :movieId")
    fun getFavoriteMovieById(movieId: Int): Flow<MovieEntity?>

    @Query("SELECT COUNT(*) FROM movies WHERE id = :movieId AND isFavorite == 1")
    fun isMovieFavorite(movieId: Int): Flow<Boolean>

    @Delete
    suspend fun removeFavoriteMovie(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteMovie(movie: MovieEntity)
}