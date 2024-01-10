package br.com.athena.home.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.athena.R
import br.com.athena.components.AthenaTopBar
import br.com.athena.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController
) {
    val viewModel: HomeViewModel = koinViewModel()

    Scaffold (
        topBar = {
            AthenaTopBar(
                title = "AthenaApp",
                mainIconResource = R.drawable.ic_menu,
                mainIconOnPressClick = { viewModel.changeDrawerState(viewModel.navigationDrawerState != DrawerValue.Open)}
            )
        },
        content = {
            Box(modifier = Modifier.padding(it)) {
                HomeContent()
            }
        }
    )
}