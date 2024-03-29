package br.com.athena.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import br.com.athena.R
import br.com.athena.theme.Dimensions.dimen_12sp
import br.com.athena.theme.Dimensions.dimen_14sp
import br.com.athena.theme.Dimensions.dimen_16sp
import br.com.athena.theme.Dimensions.dimen_18sp
import br.com.athena.theme.Dimensions.dimen_20sp
import br.com.athena.theme.Dimensions.dimen_22sp
import br.com.athena.theme.Dimensions.dimen_24sp
import br.com.athena.theme.Dimensions.dimen_26sp

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val appColors = AppColors(
        colorPrimary = colorResource(id = R.color.colorPrimary),
        colorPrimaryLight = colorResource(id = R.color.colorPrimaryLight),
        colorPrimaryExtraLight = colorResource(id = R.color.colorPrimaryExtraLight),
        colorPrimaryDark = colorResource(id = R.color.colorPrimaryDark),
        colorPrimaryVariant = colorResource(id = R.color.colorPrimaryVariant),
        colorSecondary = colorResource(id = R.color.colorSecondary),
        colorSecondaryVariant = colorResource(id = R.color.colorSecondaryVariant),
        colorWhite = Color.White,
        colorGray = Color(0xFF888888),
        colorBlack = Color.Black,
        colorMediumGray = colorResource(id = R.color.colorMediumGray),
        colorDarkGray = colorResource(id = R.color.colorDarkGray),
        colorInputError = colorResource(id = R.color.colorInputError)
    )

    val athenaTypography = AppTypography(
        topBarTitle = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = dimen_24sp,
            lineHeight = dimen_24sp,
            fontFamily = fonts
        ),
        text_12_bold = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = dimen_12sp,
            lineHeight = dimen_14sp,
            fontFamily = fonts
        ),
        text_12_normal = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = dimen_12sp,
            lineHeight = dimen_14sp,
            fontFamily = fonts
        ),
        text_14_bold = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = dimen_14sp,
            lineHeight = dimen_16sp,
            fontFamily = fonts
        ),
        text_14_normal = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = dimen_14sp,
            lineHeight = dimen_16sp,
            fontFamily = fonts
        ),
        text_16_bold = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = dimen_16sp,
            lineHeight = dimen_18sp,
            fontFamily = fonts
        ),
        text_16_normal = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = dimen_16sp,
            lineHeight = dimen_18sp,
            fontFamily = fonts
        ),
        text_18_normal = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = dimen_18sp,
            lineHeight = dimen_20sp,
            fontFamily = fonts
        ),
        text_18_bold = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = dimen_18sp,
            lineHeight = dimen_20sp,
            fontFamily = fonts
        ),
        text_20_normal = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = dimen_20sp,
            lineHeight = dimen_22sp,
            fontFamily = fonts
        ),
        text_20_bold = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = dimen_20sp,
            lineHeight = dimen_22sp,
            fontFamily = fonts
        ),
        text_24_normal = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = dimen_24sp,
            lineHeight = dimen_26sp,
            fontFamily = fonts
        ),
        text_24_bold = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = dimen_24sp,
            lineHeight = dimen_26sp,
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