package br.com.athena.signin.data

import com.google.firebase.auth.FirebaseUser

interface SignInWithEmail {
    fun signIn(
        email: String,
        password: String,
        success: (FirebaseUser?) -> Unit,
        error: (Exception?) -> Unit
    )

    fun register(
        email: String,
        password: String,
        success: (FirebaseUser?) -> Unit,
        error: (Exception?) -> Unit
    )

    fun signOut()
}