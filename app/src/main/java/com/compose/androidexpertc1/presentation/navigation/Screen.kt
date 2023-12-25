package com.compose.androidexpertc1.presentation.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object MovieDetail : Screen("movie_detail/{movieId}") {
        fun movieId(movieId: Int) = "movie_detail/$movieId"
    }
}