package br.com.athena.components.navigationdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import br.com.athena.R
import br.com.athena.theme.Dimensions.dimen_24dp
import br.com.athena.theme.Dimensions.dimen_48dp

@Composable
fun AthenaNavigationDrawer() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = dimen_24dp, top = dimen_48dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
        screens.forEach { screen ->
            Spacer(modifier = Modifier.height(dimen_24dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4
            )
        }
    }
}

sealed class DrawerScreens(val title: String) {
    object Home: DrawerScreens("Home")
}

private val screens = listOf(
    DrawerScreens.Home
)