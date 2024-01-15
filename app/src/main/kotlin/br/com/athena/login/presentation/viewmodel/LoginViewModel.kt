package br.com.athena.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.athena.hawk.HawkSession
import br.com.athena.login.data.GoogleAuthUIClient
import br.com.athena.login.presentation.ui.SignInResult
import br.com.athena.login.presentation.ui.SignInState
import br.com.athena.login.presentation.ui.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
) : ViewModel() {
    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: SignInResult) {
        _state.update {
            HawkSession.saveUserData(result.data ?: UserData())
            it.copy(
                isSignInSuccessful = result.data != null,
                signInError = result.errorMessage
            )
        }
    }

    fun resetState() {
        _state.update { SignInState() }
    }

    fun saveUserOnHawk(userData: UserData) {
        HawkSession.saveUserData(userData)
    }

    fun signOut(googleAuthUIClient: GoogleAuthUIClient) {
        viewModelScope.launch {
            googleAuthUIClient.signOut()
            HawkSession.onUserSignOut()
        }
    }
}