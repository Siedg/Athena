package br.com.athena.register.presentation.ui

data class RegisterState(
    val isRegisterSuccessful: Boolean = false,
    val registerError: String? = null
)
