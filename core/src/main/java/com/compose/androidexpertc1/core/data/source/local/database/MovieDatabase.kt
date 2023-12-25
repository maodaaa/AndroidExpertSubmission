package com.compose.androidexpertc1.core.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.compose.androidexpertc1.core.data.source.local.dao.MoviesDao
import com.compose.androidexpertc1.core.data.source.local.entity.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {

    abstract val moviesDao: MoviesDao
}