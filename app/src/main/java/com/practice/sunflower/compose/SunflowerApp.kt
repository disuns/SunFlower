package com.practice.sunflower.compose

import android.app.Activity
import androidx.appcompat.widget.Toolbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.practice.sunflower.compose.home.SunflowerPage
import com.practice.sunflower.viewmodels.PlantListViewModel

@Composable
fun SunflowerApp(
    onPageChange : (SunflowerPage) -> Unit = {},
    onAttached: (Toolbar) -> Unit = {},
    plantListViewModel : PlantListViewModel = hiltViewModel()
){
    val navController = rememberNavController()
    SunFlowerNavHost(
        plantListViewModel = plantListViewModel,
        navController = navController,
        onPageChange = onPageChange,
        onAttached = onAttached
    )
}

@Composable
fun SunFlowerNavHost(
    navController: NavHostController,
    onPageChange: (SunflowerPage) -> Unit = {},
    onAttached: (Toolbar) -> Unit = {},
    plantListViewModel: PlantListViewModel = hiltViewModel(),
) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {}
    }
}