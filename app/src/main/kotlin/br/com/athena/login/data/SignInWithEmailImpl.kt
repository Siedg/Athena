package br.com.athena.login.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import timber.log.Timber

class SignInWithEmailImpl(
    private val auth: FirebaseAuth
): SignInWithEmail {
    override fun signIn(
        email: String,
        password: String,
        success: (FirebaseUser?) -> Unit,
        error: (Exception?) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    Timber.d("Logged in")
                    success(auth.currentUser)
                } else {
                    Timber.d("Error logging in")
                    error(task.exception)
                }
            }
    }

    override fun register(
        email: String,
        password: String,
        success: (FirebaseUser?) -> Unit,
        error: (Exception?) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Timber.d("Account created!")
                } else {
                    Timber.e("Error creating account.")
                    error(task.exception)
                }
            }
    }

    override fun signOut() {
        auth.signOut()
    }
}