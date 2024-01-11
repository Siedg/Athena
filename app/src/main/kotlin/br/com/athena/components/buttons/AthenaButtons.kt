package br.com.athena.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import br.com.athena.theme.AppTheme
import br.com.athena.theme.Dimensions.dimen_16dp
import br.com.athena.theme.Dimensions.dimen_48dp
import br.com.athena.theme.Dimensions.dimen_56dp
import br.com.athena.theme.Dimensions.dimen_8dp

@Composable
fun AthenaRoundedButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    border: BorderStroke? = null,
    text: String,
    textColor: Color = Color.White,
    fontSize: TextUnit = TextUnit.Unspecified,
    height: Dp = dimen_56dp,
    backgroundColor: Color = AppTheme.colors.colorSecondary,
    shape: Shape = RoundedCornerShape(dimen_16dp),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    elevation: ButtonElevation = ButtonDefaults.elevation(),
    colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor,
        disabledBackgroundColor = backgroundColor.copy(alpha = 0.5f)
    ),
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        interactionSource = interactionSource,
        shape = shape,
        colors = colors,
        border = border,
        elevation = elevation,
        contentPadding = contentPadding,
        modifier = modifier.height(height),
        enabled = enabled
    ) {
        AthenaTextButton(
            text = text,
            color = if (enabled) textColor else textColor.copy(0.5f),
            fontSize = fontSize
        )
    }
}

@Composable
fun AthenaButtonText(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    textColor: Color = Color.White,
    height: Dp = dimen_48dp,
    backgroundColor: Color = AppTheme.colors.colorSecondary,
    roundedCornerShape: Dp = dimen_8dp,
    fontSize: TextUnit = TextUnit.Unspecified,
    onClick: () -> Unit
) {
    val color = if (enabled) backgroundColor else backgroundColor.copy(alpha = 0.5f)
    Button(
        enabled = enabled,
        onClick = { onClick() },
        shape = RoundedCornerShape(roundedCornerShape),
        colors = ButtonDefaults.textButtonColors(color),
        modifier = modifier
            .fillMaxWidth()
            .height(height)
    ) {
        AthenaTextButton(text = text, color = textColor, fontSize = fontSize)
    }
}

@Composable
fun AthenaTextButton(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppTheme.colors.colorDarkGray,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = AppTheme.typography.text_14_normal
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        style = style
    )
}
