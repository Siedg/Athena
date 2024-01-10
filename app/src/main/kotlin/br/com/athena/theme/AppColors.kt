package br.com.athena.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val colorPrimary: Color,
    val colorPrimaryVariant: Color,
    val colorSecondary: Color,
    val colorSecondaryVariant: Color,
    val colorWhite: Color,
    val colorBlack: Color,
    val colorGray: Color,
)

val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        colorPrimary = Color.Unspecified,
        colorPrimaryVariant = Color.Unspecified,
        colorSecondary = Color.Unspecified,
        colorSecondaryVariant = Color.Unspecified,
        colorWhite = Color.Unspecified,
        colorBlack = Color.Unspecified,
        colorGray = Color.Unspecified
    )
}