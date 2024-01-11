package br.com.athena.navigation

import android.app.Activity.RESULT_OK
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.athena.home.presentation.ui.HomeScreen
import br.com.athena.login.presentation.ui.GoogleAuthUIClient
import br.com.athena.login.presentation.ui.LoginScreen
import br.com.athena.login.presentation.viewmodel.LoginViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

@Composable
fun AthenaNavHost(
    context: Context
) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val googleAuthUIClient by lazy {
        GoogleAuthUIClient(
            context = context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    NavHost(navController = navController, startDestination = SIGN_IN) {
        composable(route = HOME) {
            HomeScreen(navController = navController)
        }
        composable(route = SIGN_IN) {
            LoginScreen(context = context)
        }
    }
}