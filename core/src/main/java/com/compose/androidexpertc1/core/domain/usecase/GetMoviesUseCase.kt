package com.compose.androidexpertc1.core.domain.usecase

import com.compose.androidexpertc1.core.data.repository.MoviesRepository
import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetMoviesUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Movie>?>> {
        return moviesRepository.getMovies()
    }
}