package br.com.athena.signin.data

import android.content.Intent
import android.content.IntentSender
import br.com.athena.signin.presentation.ui.SignInResult
import br.com.athena.signin.presentation.ui.UserData

interface SignInWithGoogleAuthUIClient {
    suspend fun signIn(): IntentSender?

    suspend fun signInWithIntent(intent: Intent): SignInResult

    suspend fun signOut()

    suspend fun getSignInUser(): UserData?
}