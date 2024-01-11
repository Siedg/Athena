package br.com.athena.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val colorPrimary: Color,
    val colorPrimaryLight: Color,
    val colorPrimaryExtraLight: Color,
    val colorPrimaryDark: Color,
    val colorPrimaryVariant: Color,
    val colorSecondary: Color,
    val colorSecondaryVariant: Color,
    val colorWhite: Color,
    val colorBlack: Color,
    val colorGray: Color,
    val colorMediumGray: Color,
    val colorDarkGray: Color,
    val colorInputError: Color
)

val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        colorPrimary = Color.Unspecified,
        colorPrimaryLight = Color.Unspecified,
        colorPrimaryExtraLight = Color.Unspecified,
        colorPrimaryDark = Color.Unspecified,
        colorPrimaryVariant = Color.Unspecified,
        colorSecondary = Color.Unspecified,
        colorSecondaryVariant = Color.Unspecified,
        colorWhite = Color.Unspecified,
        colorBlack = Color.Unspecified,
        colorGray = Color.Unspecified,
        colorMediumGray = Color.Unspecified,
        colorDarkGray = Color.Unspecified,
        colorInputError = Color.Unspecified
    )
}