package br.com.athena.login.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.athena.hawk.HawkSession
import br.com.athena.login.components.SignInMethod
import br.com.athena.login.data.SignInWithEmail
import br.com.athena.login.data.SignInWithGoogleAuthUIClient
import br.com.athena.login.presentation.ui.SignInResult
import br.com.athena.login.presentation.ui.SignInState
import br.com.athena.login.presentation.ui.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val signInWithEmail: SignInWithEmail,
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

    private fun signInWithEmail(email: String, password: String) {
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

    fun signOut(
        signInWithGoogleAuthUIClient: SignInWithGoogleAuthUIClient
    ) {
        when(HawkSession.getSignInMethod()) {
            SignInMethod.GOOGLE -> {
                viewModelScope.launch {
                    signInWithGoogleAuthUIClient.signOut()
                    HawkSession.onUserSignOut()
                }
            }

            SignInMethod.EMAIL -> {
                signInWithEmail.signOut()
            }
        }
    }

    fun signIn(
        signInMethod: String,
        email: String? = null,
        password: String? = null,
        signIn: () -> (Unit)
    ) {
        HawkSession.saveSignInMethod(signInMethod)
        when(signInMethod) {
            SignInMethod.GOOGLE -> {
                signIn()
            }

            SignInMethod.EMAIL -> {
                signInWithEmail(
                    email = email ?: "",
                    password = password ?: ""
                )
            }
        }
    }
}