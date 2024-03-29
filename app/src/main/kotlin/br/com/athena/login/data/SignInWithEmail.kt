package br.com.athena.login.data

import com.google.firebase.auth.FirebaseUser

interface SignInWithEmail {
    fun signIn(
        email: String,
        password: String,
        success: (FirebaseUser?) -> Unit,
        error: (Exception?) -> Unit
    )

    fun signOut()
}