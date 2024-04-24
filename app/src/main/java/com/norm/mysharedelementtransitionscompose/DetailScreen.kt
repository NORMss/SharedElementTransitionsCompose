@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.norm.mysharedelementtransitionscompose

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun SharedTransitionScope.DetailsScreen(
    url: String,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(
            model = url,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
                .sharedElement(
                    rememberSharedContentState(key = "image-$url"),
                    animatedVisibilityScope,
                ),
            contentDescription = null,
        )
        MyText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .sharedElement(
                    rememberSharedContentState(
                        key = "text-$url"
                    ),
                    animatedVisibilityScope
                ),
        )
    }
}