package br.com.athena.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import br.com.athena.R

@Immutable
data class AppTypography (
    val topBarTitle: TextStyle,
    val text_16_bold: TextStyle,
    val text_16_normal: TextStyle,
    val text_18_bold: TextStyle,
    val text_18_normal: TextStyle,
    val text_20_bold: TextStyle,
    val text_20_normal: TextStyle
)

val LocalAthenaTypography = staticCompositionLocalOf {
    AppTypography(
        topBarTitle = TextStyle.Default,
        text_16_bold = TextStyle.Default,
        text_16_normal = TextStyle.Default,
        text_18_normal = TextStyle.Default,
        text_18_bold = TextStyle.Default,
        text_20_normal = TextStyle.Default,
        text_20_bold = TextStyle.Default

    )
}

val fonts = FontFamily(
    Font(R.font.athena)
)