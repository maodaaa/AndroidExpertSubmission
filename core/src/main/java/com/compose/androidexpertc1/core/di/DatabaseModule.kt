package com.compose.androidexpertc1.core.di

import android.content.Context
import androidx.room.Room
import com.compose.androidexpertc1.core.data.source.local.dao.MoviesDao
import com.compose.androidexpertc1.core.data.source.local.database.MovieDatabase
import com.compose.androidexpertc1.core.utils.Constant.MOVIES_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Singleton
    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("abogaboga".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            MOVIES_DATABASE
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideMoviesDao(movieDatabase: MovieDatabase): MoviesDao {
        return movieDatabase.moviesDao
    }
}