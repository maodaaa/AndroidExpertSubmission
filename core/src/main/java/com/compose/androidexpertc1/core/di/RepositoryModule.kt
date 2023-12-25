package com.compose.androidexpertc1.core.di

import com.compose.androidexpertc1.core.data.repository.MoviesRepository
import com.compose.androidexpertc1.core.domain.repository.IMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(moviesRepository: MoviesRepository): IMoviesRepository

}