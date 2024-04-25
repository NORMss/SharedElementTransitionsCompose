package com.norm.mysharedelementtransitionscompose.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.norm.mysharedelementtransitionscompose.model.items

@Composable
fun MyText(
    modifier: Modifier = Modifier,
    imageId: Int,
    maxLines: Int = Int.MAX_VALUE,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = items[imageId - 1].about,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = items[imageId - 1].author,
            style = MaterialTheme.typography.labelLarge,
        )
        Text(
            text = items[imageId - 1].location,
            modifier = Modifier
                .alpha(0.5f),
            style = MaterialTheme.typography.labelSmall,
        )
    }
}