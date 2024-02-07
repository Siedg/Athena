package br.com.athena.register.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import timber.log.Timber

class RegisterWithEmailImpl(
    private val auth: FirebaseAuth
) : RegisterWithEmail {
    override fun register(
        email: String,
        password: String,
        success: (FirebaseUser?) -> Unit,
        error: (Exception?) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Timber.d("Account created")
                } else {
                    Timber.e("Error creating account")
                    error(task.exception)
                }
            }
    }
}
