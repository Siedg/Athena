package br.com.athena.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

@Immutable
data class AppTypography (
    val topBarTitle: TextStyle,
    val body_bold: TextStyle
)

val LocalAthenaTypography = staticCompositionLocalOf {
    AppTypography(
        topBarTitle = TextStyle.Default,
        body_bold = TextStyle.Default

    )
}

val fonts = FontFamily(
    //Font()
)