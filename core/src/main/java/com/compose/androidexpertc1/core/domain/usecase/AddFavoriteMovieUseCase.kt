package com.compose.androidexpertc1.core.domain.usecase

import com.compose.androidexpertc1.core.data.repository.MoviesRepository
import com.compose.androidexpertc1.core.data.resource.Resource
import com.compose.androidexpertc1.core.domain.model.MovieDetail
import javax.inject.Inject


class AddFavoriteMovieUseCase @Inject constructor(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke(movie: MovieDetail): Resource<Unit> {
        return moviesRepository.addFavoriteMovie(movie)
    }
}