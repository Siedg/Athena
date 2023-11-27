package br.com.athena.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import br.com.athena.R
import br.com.athena.theme.Dimensions.dimen_16sp
import br.com.athena.theme.Dimensions.dimen_18sp
import br.com.athena.theme.Dimensions.dimen_24sp

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val appColors = AppColors(
        colorPrimary = colorResource(id = R.color.colorPrimary),
        colorSecondary = colorResource(id = R.color.colorSecondary),
        colorWhite = Color.White,
        colorGray = Color(0xFF888888),
        colorBlack = Color.Black
    )

    val athenaTypography = AppTypography(
        topBarTitle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = dimen_24sp,
            lineHeight = dimen_24sp,
            fontFamily = fonts
        ),
        body_bold = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = dimen_16sp,
            lineHeight = dimen_18sp,
            fontFamily = fonts
        )
    )

    CompositionLocalProvider(
        LocalAppColors provides appColors,
        LocalAthenaTypography provides athenaTypography,
        content = content
    )
}

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        get() = LocalAthenaTypography.current
}