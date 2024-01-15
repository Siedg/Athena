package br.com.athena.login.presentation.ui

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
