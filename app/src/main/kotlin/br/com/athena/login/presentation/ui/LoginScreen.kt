package br.com.athena.login.presentation.ui

import android.content.Context
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    context: Context
) {
    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .padding(it),
            ) {
                LoginContent(context = context)
            }
        }
    )
}