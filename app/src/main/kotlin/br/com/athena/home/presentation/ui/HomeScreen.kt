package br.com.athena.home.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.athena.components.AthenaTopBar
import br.com.athena.components.navigationdrawer.AthenaNavigationDrawer
import br.com.athena.home.presentation.viewmodel.HomeViewModel
import br.com.athena.navigation.HOME
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController
) {
    val viewModel: HomeViewModel = koinViewModel()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold (
        scaffoldState = scaffoldState,
        topBar = {
            AthenaTopBar(
                title = "AthenaApp",
                hasNavigationDrawer = true,
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            AthenaNavigationDrawer(
                onItemClick = {
                    when(it.route) {
                        HOME -> {}
                    }
                }
            )
        },
        content = {
            Box(modifier = Modifier.padding(it)) {
                HomeContent()
            }
        }
    )
}