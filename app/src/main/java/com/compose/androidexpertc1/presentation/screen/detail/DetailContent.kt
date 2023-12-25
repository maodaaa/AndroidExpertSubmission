package com.compose.androidexpertc1.presentation.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.compose.androidexpertc1.core.domain.model.MovieDetail
import com.compose.androidexpertc1.presentation.components.RatingMovie
import com.compose.androidexpertc1.presentation.components.ReleaseDate
import com.compose.androidexpertc1.presentation.utils.Constant.POSTER_IMAGE_URL

@Composable
fun DetailContent(
    movie: MovieDetail,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = POSTER_IMAGE_URL + movie.posterPath)
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                        scale(Scale.FIT)
                    }).build()
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.FillWidth
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = movie.status ?: "",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "${movie.runtime} Minutes",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            movie.releaseDate?.let {
                ReleaseDate(releaseDate = it)
            }
            Spacer(modifier = Modifier.height(8.dp))
            movie.voteAverage?.let {
                RatingMovie(
                    rating = it
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movie.overview,
                style = MaterialTheme.typography.bodyLarge
            )

        }
    }
}