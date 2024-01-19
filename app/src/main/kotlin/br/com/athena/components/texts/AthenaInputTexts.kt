package br.com.athena.components.texts

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.athena.theme.AppTheme
import br.com.athena.theme.Dimensions.dimen_8dp

@Composable
fun AthenaInputText(
    modifier: Modifier = Modifier,
    state: ErrorTextFieldState? = null,
    mask: String? = null,
    filterChar: ((value: String) -> String)? = null,
    componentBackgroundColor: Color = Color.White,
    label: String = "",
    labelColor: Color = AppTheme.colors.colorDarkGray,
    borderColor: Color = AppTheme.colors.colorPrimaryLight,
    placeholder: String = "",
    placeholderColor: Color = AppTheme.colors.colorDarkGray,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    shape: Shape = CircleShape,
    startPadding: Dp = dimen_8dp,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        textColor = AppTheme.colors.colorDarkGray,
        backgroundColor = Color.White,
        focusedIndicatorColor = AppTheme.colors.colorPrimaryLight,
        unfocusedIndicatorColor = Color.Gray,
        disabledIndicatorColor = Color.Transparent,
        cursorColor = AppTheme.colors.colorDarkGray,
    ),
    callback: (() -> Unit)? = null
) {
    val error = state?.error
    val isEmptyText = remember { mutableStateOf(true) }
    val hasFocus = remember { mutableStateOf(false) }
    Column(
        modifier = modifier
            .background(color = colorResource(R.color.transparent)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = if (error != null) 2.dp else 1.dp,
                    color = if (error != null) {
                        AppTheme.colors.colorInputError
                    } else if (hasFocus.value) {
                        AppTheme.colors.colorPrimaryLight
                    } else {
                        AppTheme.colors.colorMediumGray
                    },
                    shape = shape
                )
                .clip(shape = shape)
                .background(color = componentBackgroundColor)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = startPadding)
                    .onFocusChanged { hasFocus.value = it.isFocused },
                value = state?.text ?: "",
                onValueChange = { value ->
                    val newValue = filterChar?.invoke(value) ?: value

                    if (mask != null) {
                        if (newValue.length <= mask.count { char -> char == '#' }) {
                            state?.updateText(newValue)
                        }
                    } else {
                        state?.updateText(newValue)
                    }
                    state?.validate()
                    if (mask != null && state?.error == null && newValue.length == mask.count { char -> char == '#' }
                    ) {
                        callback?.invoke()
                    }
                    isEmptyText.value = value.isEmpty()
                },
                label = {
                    CreateLabel(
                        label = label,
                        error = error,
                        labelColor = labelColor,
                        isEmptyText = isEmptyText.value,
                        hasFocus = hasFocus.value
                    )
                },
                placeholder = {
                    CreatePlaceholder(placeholder, placeholderColor)
                },
                shape = shape,
                enabled = enabled,
                readOnly = readOnly,
                textStyle = textStyle,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                singleLine = singleLine,
                maxLines = maxLines,
                colors = colors,
            )
        }
        if (error != null) {
            ShowErrorMessage(error)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AthenaEmailInputText(
    modifier: Modifier = Modifier,
    emailState: ErrorTextFieldState,
    keyboardController: SoftwareKeyboardController?,
    loadingState: MutableState<Boolean>,
    label: String? = null
) {
    AthenaInputText(
        modifier = modifier
            .fillMaxWidth(),
        state = emailState,
        label = label ?: stringResource(br.com.athena.R.string.email_label),
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Email
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() },
        ),
        enabled = !loadingState.value
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AthenaPasswordInputText(
    modifier: Modifier = Modifier,
    passwordState: ErrorTextFieldState,
    keyboardController: SoftwareKeyboardController?,
    loadingState: MutableState<Boolean>,
    passwordVisible: MutableState<Boolean>,
    label: String? = null
) {
    AthenaInputText(
        modifier = modifier
            .fillMaxWidth(),
        state = passwordState,
        label = label ?: "Senha",
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() },
        ),
        enabled = !loadingState.value,
        trailingIcon = {
            Row(
                modifier = Modifier
                    .padding(end = dimen_8dp)
                    .clickable {
                        passwordVisible.value = !passwordVisible.value
                    },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val image = if (passwordVisible.value)
                    Icons.Default.Check // show
                else Icons.Default.Lock // hide

                val description = if (!passwordVisible.value) {
                    stringResource(br.com.athena.R.string.show_password_label)
                } else {
                    stringResource(br.com.athena.R.string.hide_password_label)
                }

                AthenaText_12Normal(
                    text = description,
                    color = AppTheme.colors.colorPrimary,
                    fontSize = 14.sp
                )

                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(
                        imageVector = image, description,
                        tint = AppTheme.colors.colorPrimary
                    )
                }
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
private fun CreatePlaceholder(placeholder: String, placeholderColor: Color) {
    AthenaText_16Bold(
        text = placeholder,
        color = placeholderColor,
    )
}

@Composable
private fun CreateLabel(
    label: String,
    error: String?,
    labelColor: Color,
    isEmptyText: Boolean,
    hasFocus: Boolean
) {
    if (!isEmptyText || hasFocus) {
        AthenaText_14Bold(
            text = label,
            color = if (error != null) {
                AppTheme.colors.colorInputError
            } else {
                AppTheme.colors.colorPrimary
            },
        )
    } else {
        AthenaText_18Bold(
            text = label,
            color = if (error != null) AppTheme.colors.colorInputError else labelColor,
        )
    }
}

@Composable
private fun ShowErrorMessage(error: String) {
    AthenaText_16Normal(
        modifier = Modifier.padding(start = 24.dp, top = 4.dp),
        text = error,
        color = AppTheme.colors.colorInputError
    )
}

@Composable
fun rememberErrorTextFieldState(
    initialText: String,
    validate: (String) -> String? = { null },
): ErrorTextFieldState {
    return rememberSaveable(saver = ErrorTextFieldState.Saver(validate)) {
        ErrorTextFieldState(initialText, validate)
    }
}
