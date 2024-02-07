package br.com.athena.register.presentation.viewmodel

import androidx.lifecycle.ViewModel
import br.com.athena.register.data.RegisterWithEmail
import br.com.athena.register.presentation.ui.RegisterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel(
    private val registerWithEmail: RegisterWithEmail
) : ViewModel() {
    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()

    fun register(email: String, password: String) {
        registerWithEmail.register(
            email = email,
            password = password,
            success = {
                _state.update { it.copy(isRegisterSuccessful = true) }
            },
            error = {
                _state.update {
                    it.copy(
                        isRegisterSuccessful = false,
                        registerError = it.registerError
                    )
                }
            }
        )
    }
}
