package br.com.athena.home.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.athena.components.bottombar.AthenaBottomBar
import br.com.athena.components.topbar.AthenaTopBar
import br.com.athena.components.bottombar.BottomNavigationItem
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

    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Chat",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasNews = false,
            badgeCount = 12
        ),
        BottomNavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = true
        )
    )

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
        bottomBar = {
            AthenaBottomBar(items)
        },
        content = {
            Box(modifier = Modifier.padding(it)) {
                HomeContent()
            }
        }
    )
}