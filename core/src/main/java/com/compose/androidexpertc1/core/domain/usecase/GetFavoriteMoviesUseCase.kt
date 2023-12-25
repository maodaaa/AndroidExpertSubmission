package com.compose.androidexpertc1.core.domain.usecase

import com.compose.androidexpertc1.core.data.repository.MoviesRepository
import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    operator fun invoke(): Flow<Resource<List<Movie>?>> {
        return moviesRepository.getAllFavoriteMovies()
    }
}