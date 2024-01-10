package br.com.athena.components.navigationdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.DrawerState
import androidx.compose.material.ModalDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import br.com.athena.R
import br.com.athena.components.texts.AthenaText_16Normal
import br.com.athena.navigation.HOME
import br.com.athena.theme.AppTheme
import br.com.athena.theme.Dimensions.dimen_16dp
import br.com.athena.theme.Dimensions.dimen_1dp
import br.com.athena.theme.Dimensions.dimen_24dp
import br.com.athena.theme.Dimensions.dimen_96dp

@Composable
fun AthenaNavigationDrawer(
    icon: Int,
    text: String,
    drawerState: DrawerState,
    gesturesEnabled: Boolean = drawerState.isOpen,
    modifier: Modifier = Modifier,
) {
    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = gesturesEnabled,
        drawerElevation = dimen_1dp,
        drawerContent = {
            Column(
                modifier = Modifier
                    .background(color = AppTheme.colors.colorWhite)
                    .fillMaxSize()
                    .padding(start = dimen_16dp, top = dimen_16dp)
            ) {
                Image(
                    modifier = Modifier.size(dimen_96dp),
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = AppTheme.colors.colorPrimary)
                )
                screens.forEach { screen ->
                    Spacer(modifier = Modifier.height(dimen_24dp))
                    AthenaText_16Normal(
                        modifier = Modifier.clickable {  },
                        text = screen.title,
                    )
                }
            }
        }
    ) {

    }

}

sealed class DrawerScreens(val title: String, val route: String) {
    object Home: DrawerScreens("Home", HOME)
    object PlaceHolder: DrawerScreens("PlaceHolder", HOME)
}

private val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.PlaceHolder
)