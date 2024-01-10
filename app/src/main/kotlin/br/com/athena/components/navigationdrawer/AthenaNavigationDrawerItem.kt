package br.com.athena.components.navigationdrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.athena.R
import br.com.athena.navigation.HELP
import br.com.athena.navigation.HOME
import br.com.athena.navigation.SETTINGS

sealed class AthenaNavigationDrawerItem(
    val title: String,
    val route: String,
    val contentDescription: String = "",
    val icon: ImageVector,
    val iconColor: Int = R.color.colorPrimary
) {
    object Home: AthenaNavigationDrawerItem(
        title = "Home",
        route = HOME,
        icon = Icons.Default.Menu,
    )
    object Settings: AthenaNavigationDrawerItem(
        title = "Settings",
        route = SETTINGS,
        icon = Icons.Default.Settings
    )
    object Help: AthenaNavigationDrawerItem(
        title = "Help",
        route = HELP,
        icon = Icons.Default.Info
    )
}

