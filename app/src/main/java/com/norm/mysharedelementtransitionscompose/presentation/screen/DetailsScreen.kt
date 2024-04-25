@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.norm.mysharedelementtransitionscompose.presentation.screen

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.norm.mysharedelementtransitionscompose.model.items
import com.norm.mysharedelementtransitionscompose.presentation.component.MyText

@Composable
fun SharedTransitionScope.DetailsScreen(
    imageId: Int,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AsyncImage(
            model = items[imageId - 1].photo,
            modifier = Modifier
                .sharedElement(
                    rememberSharedContentState(key = "image-${imageId}"),
                    animatedVisibilityScope = animatedVisibilityScope,
                )
                .aspectRatio(4f / 3f)
                .fillMaxWidth()
                .clickable {
                    onClick()
                },
            contentDescription = null,
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        MyText(
            modifier = Modifier
                .sharedBounds(
                    rememberSharedContentState(
                        key = "text-${imageId}"
                    ),
                    animatedVisibilityScope = animatedVisibilityScope
                )
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            imageId = imageId,
        )
    }
}