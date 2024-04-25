@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.norm.mysharedelementtransitionscompose.presentation.component

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.norm.mysharedelementtransitionscompose.model.UnsplashImage

@Composable
fun SharedTransitionScope.UnsplashImageView(
    animatedVisibilityScope: AnimatedVisibilityScope,
    data: UnsplashImage,
    onClick: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onClick(data.id)
            }
            .padding(8.dp)
    ) {
        AsyncImage(
            model = data.photo,
            modifier = Modifier
                .sharedElement(
                    state = rememberSharedContentState(
                        key = "image-${data.id}"
                    ),
                    animatedVisibilityScope = animatedVisibilityScope,
                )
                .size(128.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Spacer(Modifier.width(8.dp))
        MyText(
            modifier = Modifier
                .sharedBounds(
                    rememberSharedContentState(
                        key = "text-${data.id}"
                    ),
                    animatedVisibilityScope = animatedVisibilityScope,
                )
                .fillMaxWidth()
                .skipToLookaheadSize(),
            imageId = data.id,
            maxLines = 2,
        )
    }
}