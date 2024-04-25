@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.norm.mysharedelementtransitionscompose.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.norm.mysharedelementtransitionscompose.presentation.screen.DetailsScreen
import com.norm.mysharedelementtransitionscompose.presentation.screen.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    SharedTransitionLayout {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
        ) {
            composable(
                route = Screen.Home.route
            ) {
                HomeScreen(
                    animatedVisibilityScope = this@composable,
                    onClick = { imageId ->
                        navController.navigate(Screen.Details.passImageId(imageId))
                    },
                )
            }
            composable(
                route = Screen.Details.route,
                arguments = listOf(navArgument(name = IMAGE_ID_ARG) {
                    type = NavType.IntType
                }),
            ) {
                val imageId = it.arguments?.getInt(IMAGE_ID_ARG) ?: 1
                DetailsScreen(
                    imageId = imageId,
                    animatedVisibilityScope = this@composable,
                    onClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}