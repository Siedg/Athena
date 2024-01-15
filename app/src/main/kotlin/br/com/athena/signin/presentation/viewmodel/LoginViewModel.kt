package br.com.athena.signin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.athena.hawk.HawkSession
import br.com.athena.signin.data.SignInWithEmail
import br.com.athena.signin.data.SignInWithGoogleAuthUIClient
import br.com.athena.signin.presentation.ui.SignInResult
import br.com.athena.signin.presentation.ui.SignInState
import br.com.athena.signin.presentation.ui.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val signInWithEmail: SignInWithEmail
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

    fun signInWithEmail(email: String, password: String) {
        signInWithEmail.signIn(
            email = email,
            password = password,
            success = {  },
            error = {  }
        )
    }

    fun resetState() {
        _state.update { SignInState() }
    }

    fun saveUserOnHawk(userData: UserData) {
        HawkSession.saveUserData(userData)
    }

    fun signOut(signInWithGoogleAuthUIClient: SignInWithGoogleAuthUIClient) {
        viewModelScope.launch {
            signInWithGoogleAuthUIClient.signOut()
            HawkSession.onUserSignOut()
        }
    }
}