package br.com.athena.signin.presentation.ui

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
