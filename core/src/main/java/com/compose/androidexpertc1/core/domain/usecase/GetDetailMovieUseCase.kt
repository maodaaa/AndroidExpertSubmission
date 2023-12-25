package com.compose.androidexpertc1.core.domain.usecase

import com.compose.androidexpertc1.core.data.repository.MoviesRepository
import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDetailMovieUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(id: Int): Flow<Resource<MovieDetail?>> {
        return moviesRepository.getDetailMovie(id)
    }
}