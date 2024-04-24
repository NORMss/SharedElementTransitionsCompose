@file:OptIn(ExperimentalSharedTransitionApi::class, ExperimentalSharedTransitionApi::class,
    ExperimentalSharedTransitionApi::class
)

package com.norm.mysharedelementtransitionscompose

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.net.URLDecoder
import java.net.URLEncoder

@Composable
fun Home(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    SharedTransitionLayout(
        modifier = modifier,
    ) {
        NavHost(
            navController = navController,
            startDestination = "list",
            modifier = Modifier
                .fillMaxSize(),
        ) {
            composable(
                route = "list",
            ) {
                ItemsList(
                    animatedVisibilityScope = this@composable,
                    onItemClick = { item ->
                        val encoded = URLEncoder.encode(item, "UTF-8")
                        navController.navigate("details/$encoded")
                    },
                    modifier = Modifier
                        .fillMaxSize(),
                )
            }
            composable(
                route = "details/{url}"
            ) { navBackStackEntry ->
                val encoded = navBackStackEntry.arguments?.getString("url") ?: ("No url")
                val url = URLDecoder.decode(encoded, "UTF-8")
                DetailsScreen(
                    url = url,
                    animatedVisibilityScope = this@composable,
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}