package br.com.athena.register.presentation.ui

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import br.com.athena.R
import br.com.athena.components.buttons.AthenaButtonText
import br.com.athena.components.texts.AthenaEmailInputText
import br.com.athena.components.texts.AthenaInputText
import br.com.athena.components.texts.AthenaPasswordInputText
import br.com.athena.components.texts.AthenaText_20Bold
import br.com.athena.components.texts.rememberErrorTextFieldState
import br.com.athena.navigation.Routes.SIGN_IN
import br.com.athena.register.presentation.viewmodel.RegisterViewModel
import br.com.athena.theme.Dimensions.dimen_16dp
import br.com.athena.theme.Dimensions.dimen_8dp
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterContent(
    navController: NavController
) {
    val viewModel: RegisterViewModel = koinViewModel()
    val state by viewModel.state.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val loadingState = remember { mutableStateOf(false) }
    val nameState = rememberErrorTextFieldState(
        initialText = "",
        validate = { text ->
            if (text.isEmpty()) {
                "O nome deve ser preenchido"
            } else {
                null
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

    val emailConfirmationState = rememberErrorTextFieldState(
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
        initialText = "",
        validate = { text ->
            if (text.isEmpty()) {
                "Digite uma senha"
            } else {
                null
            }
        }
    )

    val passwordConfirmationState = rememberErrorTextFieldState(
        initialText = "",
        validate = { text ->
            if (text.isEmpty()) {
                "Digite uma senha"
            } else if (passwordState.text.isNotEmpty() && text != passwordState.text) {
                "A senha e a confirmação devem ser iguais"
            } else {
                null
            }
        }
    )

    val passwordVisible = rememberSaveable { mutableStateOf(false) }

    val isAllFieldsValid = remember(
        nameState.text,
        emailState.text,
        emailConfirmationState.text,
        passwordState.text,
        passwordConfirmationState.text
    ) {
        derivedStateOf {
            nameState.isValid &&
            emailState.isValid && 
            emailConfirmationState.isValid &&
            passwordState.isValid &&
            passwordConfirmationState.isValid
        }
    }

    LaunchedEffect(key1 = state.isRegisterSuccessful) {
        navController.navigate(SIGN_IN)
    }

    LaunchedEffect(key1 = state.registerError) {
        state.registerError?.let {

        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = dimen_16dp),
        verticalArrangement = Arrangement.Center
    ) {
        AthenaText_20Bold(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.register_title)
        )

        AthenaInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimen_8dp),
            state = nameState,
            label = stringResource(id = R.string.register_name_label)
        )

        AthenaEmailInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimen_8dp),
            emailState = emailState,
            keyboardController = keyboardController,
            loadingState = loadingState
        )

        AthenaEmailInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimen_8dp),
            emailState = emailConfirmationState,
            keyboardController = keyboardController,
            loadingState = loadingState,
            label = stringResource(id = R.string.register_confirm_email_label)
        )
        
        AthenaPasswordInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimen_8dp),
            passwordState = passwordState,
            keyboardController = keyboardController,
            loadingState = loadingState,
            passwordVisible = passwordVisible
        )

        AthenaPasswordInputText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimen_8dp),
            passwordState = passwordConfirmationState,
            keyboardController = keyboardController,
            loadingState = loadingState,
            passwordVisible = passwordVisible,
            label = stringResource(id = R.string.register_confirm_password_label)
        )

        AthenaButtonText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimen_16dp),
            enabled = isAllFieldsValid.value,
            text = stringResource(id = R.string.continue_button)
        ) {
            viewModel.register(
                email = emailState.text,
                password = passwordState.text
            )
        }
    }
}
