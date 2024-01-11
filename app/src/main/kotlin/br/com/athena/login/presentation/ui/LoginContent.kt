package br.com.athena.login.presentation.ui

import android.app.Activity
import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import br.com.athena.R
import br.com.athena.components.buttons.AthenaRoundedButton
import br.com.athena.components.texts.AthenaEmailInputText
import br.com.athena.components.texts.AthenaInputText
import br.com.athena.components.texts.AthenaPasswordInputText
import br.com.athena.components.texts.AthenaText_24Bold
import br.com.athena.components.texts.rememberErrorTextFieldState
import br.com.athena.home.presentation.viewmodel.HomeViewModel
import br.com.athena.login.presentation.viewmodel.LoginViewModel
import br.com.athena.theme.Dimensions.dimen_16dp
import br.com.athena.theme.Dimensions.dimen_32dp
import br.com.athena.theme.Dimensions.dimen_64dp
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginContent(
    context: Context
) {
    val viewModel: LoginViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val scope = rememberCoroutineScope()
    val googleAuthUIClient by lazy {
        GoogleAuthUIClient(
            context = context,
            oneTapClient = Identity.getSignInClient(context)
        )
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                scope.launch {
                    val signInResult = googleAuthUIClient.signInWithIntent(
                        intent = result.data ?: return@launch
                    )
                    viewModel.onSignInResult(signInResult)
                }
            }
        }
    )

    val emailState = rememberErrorTextFieldState(
        "",
        validate = { text ->
            if (!Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                "E-mail inválido"
            } else {
                null
            }
        }
    )
    val passwordState = rememberErrorTextFieldState(
        ""
    )

    val loadingState = remember { mutableStateOf(false) }
    val passwordVisible = rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    LaunchedEffect(key1 = state.isSignInSuccessful) {
        if (state.isSignInSuccessful) {
            Toast.makeText(
                context,
                "Sign in successful",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimen_16dp)
            .padding(top = dimen_32dp)
    ) {
        AthenaText_24Bold(
            modifier = Modifier
                .padding(top = dimen_32dp),
            text = stringResource(id = R.string.login_title)
        )

        AthenaEmailInputText(
            modifier = Modifier.padding(top = dimen_32dp),
            emailState = emailState,
            keyboardController = keyboardController,
            loadingState = loadingState
        )

        AthenaPasswordInputText(
            modifier = Modifier.padding(top = dimen_16dp),
            passwordState = passwordState,
            keyboardController = keyboardController,
            loadingState = loadingState,
            passwordVisible = passwordVisible
        )

        AthenaRoundedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimen_64dp)
                .padding(top = dimen_16dp),
            shape = RoundedCornerShape(dimen_64dp),
            text = stringResource(id = R.string.login_button)
        ) {
            scope.launch {
                val signInIntentSender = googleAuthUIClient.signIn()
                launcher.launch(
                    IntentSenderRequest.Builder(
                        signInIntentSender ?: return@launch
                    ).build()
                )
            }
        }
    }
}
