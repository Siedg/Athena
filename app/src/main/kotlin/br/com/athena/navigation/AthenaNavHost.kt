package br.com.athena.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

//            LaunchedEffect(key1 = Unit) {
//                if (HawkSession.isUserLoggedIn()) {
//                    navController.navigate(SIGN_IN)
//                }
//            }
        }
        composable(
            route = SIGN_IN,
            arguments = listOf(navArgument(Argument.SIGN_OUT) { defaultValue = false })
        ) {
            LoginScreen(
                context = context,
                navController = navController,
                signOut = it.arguments?.getBoolean(SIGN_OUT) ?: false
            )
        }
    }
}