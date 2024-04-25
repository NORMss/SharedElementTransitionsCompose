package com.norm.mysharedelementtransitionscompose.navigation

const val IMAGE_ID_ARG = "imageId"

sealed class Screen(val route: String) {
    data object Home : Screen(route = "home_screen")
    data object Details : Screen(route = "details_screen/{$IMAGE_ID_ARG}") {
        fun passImageId(id: Int) = "details_screen/$id"
    }
}