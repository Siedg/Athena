package br.com.athena.home.presentation.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen() {
    Scaffold (
        content = {
            HomeContent()
        }
    )
}