package br.com.athena.register.data

import com.google.firebase.auth.FirebaseUser

interface RegisterWithEmail {
    fun register(
        email: String,
        password: String,
        success: (FirebaseUser?) -> Unit,
        error: (Exception?) -> Unit
    )
}
