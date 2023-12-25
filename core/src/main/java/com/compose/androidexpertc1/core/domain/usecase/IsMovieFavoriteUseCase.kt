package com.compose.androidexpertc1.core.domain.usecase

import com.compose.androidexpertc1.core.data.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class IsMovieFavoriteUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    operator fun invoke(movieId: Int): Flow<Boolean> {
        return moviesRepository.isMovieFavorite(movieId)
    }
}