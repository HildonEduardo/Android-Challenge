package com.podium.technicalchallenge.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.podium.technicalchallenge.R
import com.podium.technicalchallenge.data.model.Movie

/**
 * Created by hildon.lima<hildon.eduardo@gmail.com> on 04/05/24.
 */
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
        //.aspectRatio(0.6667f) // Set the card aspect ratio to match the poster
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp) // Set the height of the poster
            ) {
                GlideImage(
                    model = movie.posterPath,
                    contentDescription = stringResource(id = R.string.movie_banner_descriptor),
                    modifier = Modifier
                        .clickable(onClick = onClick)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            StarRating(
                voteAverage = movie.voteAverage.toFloat(), modifier = Modifier.align(
                    Alignment.Start
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2, // Set the maximum number of lines to 2
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.heightIn(min = 48.dp, max = 48.dp)
            )
        }
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(
        movie = Movie(
            "tes",
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
            "",
            "title",
            10.0
        )
    ) {

    }
}