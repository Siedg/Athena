package br.com.athena.register.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import br.com.athena.theme.AppTheme

@Composable
fun RegisterScreen(
    navController: NavController
) {
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
                    .background(color = AppTheme.colors.colorPrimaryExtraLight),
            ) {
                RegisterContent(
                    navController = navController
                )
            }
        }
    )
}