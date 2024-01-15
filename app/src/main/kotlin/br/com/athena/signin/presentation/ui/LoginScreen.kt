package br.com.athena.signin.presentation.ui

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    context: Context,
    navController: NavController,
    signOut: Boolean
) {
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .padding(it),
            ) {
                LoginContent(
                    context = context,
                    navController = navController,
                    signOut = signOut
                )
            }
        }
    )
}