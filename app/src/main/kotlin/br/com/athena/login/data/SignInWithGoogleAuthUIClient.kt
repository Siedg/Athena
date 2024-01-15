package br.com.athena.login.data

import android.content.Intent
import android.content.IntentSender
import br.com.athena.login.presentation.ui.SignInResult
import br.com.athena.login.presentation.ui.UserData

interface SignInWithGoogleAuthUIClient {
    suspend fun signIn(): IntentSender?

    suspend fun signInWithIntent(intent: Intent): SignInResult

    suspend fun signOut()

    suspend fun getSignInUser(): UserData?
}