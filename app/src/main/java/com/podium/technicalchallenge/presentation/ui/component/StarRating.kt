package com.podium.technicalchallenge.presentation.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun StarRating(voteAverage: Float, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = null,
            tint = Color.Yellow,
            modifier = modifier
        )
        Text(
            text = " $voteAverage",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}
