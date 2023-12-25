package com.compose.androidexpertc1.presentation.screen.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.compose.androidexpertc1.core.domain.model.Movie
import com.compose.androidexpertc1.presentation.components.MovieCard
import com.compose.androidexpertc1.presentation.navigation.Screen
import com.compose.androidexpertc1.presentation.utils.Constant.POSTER_IMAGE_URL


@Composable
fun HomeContent(
    movies: List<Movie>,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        columns = GridCells.Fixed(2),
        content = {
            items(movies, key = { movies -> movies.id }) { movie ->
                MovieCard(
                    modifier = Modifier.padding(8.dp),
                    imageUrl = POSTER_IMAGE_URL + movie.posterPath,
                    title = movie.title,
                    contentDescription = movie.title,
                    onClick = {
                        navController.navigate(
                            route = Screen.MovieDetail.movieId(
                                movie.id
                            )
                        )
                    }
                )
            }
        }
    )
}

