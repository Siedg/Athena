package br.com.athena.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.athena.home.presentation.ui.HomeScreen

@Composable
fun AthenaNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME) {
        composable(route = HOME) {
            HomeScreen(navController = navController)
        }

    }
}