package br.com.athena.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.athena.home.presentation.ui.HomeScreen
import br.com.athena.login.presentation.ui.LoginScreen

@Composable
fun AthenaNavHost(
    context: Context
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SIGN_IN) {
        composable(route = HOME) {
            HomeScreen(navController = navController)
        }
        composable(route = SIGN_IN) {
            LoginScreen(context = context)
        }
    }
}