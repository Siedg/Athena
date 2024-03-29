package br.com.athena.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.athena.hawk.HawkSession
import br.com.athena.home.presentation.ui.HomeScreen
import br.com.athena.login.presentation.ui.LoginScreen
import br.com.athena.navigation.Routes.HOME
import br.com.athena.navigation.Routes.REGISTER
import br.com.athena.navigation.Routes.SIGN_IN
import br.com.athena.register.presentation.ui.RegisterScreen

@Composable
fun AthenaNavHost(
    context: Context
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = REGISTER) {
        composable(route = HOME) {
            HomeScreen(navController = navController)
        }
        composable(
            route = SIGN_IN,
            arguments = listOf(navArgument(Argument.SIGN_OUT) { defaultValue = false })
        ) {
            LaunchedEffect(key1 = Unit) {
                if (HawkSession.isUserLoggedIn()) {
                    navController.navigate(HOME)
                }
            }
            LoginScreen(
                context = context,
                navController = navController,
                signOut = it.arguments?.getBoolean(Argument.SIGN_OUT) ?: false
            )
        }
        composable(route = REGISTER) {
            RegisterScreen(navController = navController)
        }
    }
}