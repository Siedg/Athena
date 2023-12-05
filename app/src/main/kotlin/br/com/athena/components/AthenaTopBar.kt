package br.com.athena.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import br.com.athena.components.texts.AthenaText_16Bold
import br.com.athena.theme.AppTheme
import br.com.athena.theme.Dimensions.dimen_12dp
import br.com.athena.theme.Dimensions.dimen_22dp
import br.com.athena.theme.Dimensions.dimen_24dp
import br.com.athena.theme.Dimensions.dimen_8dp

@Composable
fun AthenaTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    titleColor: Color = AppTheme.colors.colorGray,
    mainIconResource: Int? = null,
    mainIconColor: Color? = null,
    mainIconOnPressClick: () -> Unit = {},
    firstIconResource: Int? = null,
    firstIconColor: Color? = null,
    firstIconOnPressClick: () -> Unit = {},
    secondIconResource: Int? = null,
    secondIconColor: Color? = null,
    secondIconOnPressClick: () -> Unit = {},
    backgroundColor: Color? = null,
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
) {
    TopAppBar(
        backgroundColor = backgroundColor ?: Color.White,
        elevation = elevation,
        modifier = modifier,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = dimen_12dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    mainIconResource?.apply {
                        Icon(
                            modifier = Modifier
                                .size(dimen_24dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = true)
                                ) { mainIconOnPressClick() },
                            painter = painterResource(id = mainIconResource),
                            tint = mainIconColor ?: AppTheme.colors.colorPrimary,
                            contentDescription = null
                        )
                    }
                    AthenaText_16Bold(
                        modifier = Modifier.padding(
                            start = if(mainIconResource != null) dimen_22dp else dimen_8dp
                        ),
                        text = title ?: "",
                        color = titleColor
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    firstIconResource?.apply {
                        Icon(
                            modifier = Modifier
                                .size(dimen_24dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = true)
                                ) { firstIconOnPressClick() },
                            painter = painterResource(id = firstIconResource),
                            tint = firstIconColor ?: AppTheme.colors.colorPrimary,
                            contentDescription = null
                        )
                    }

                    secondIconResource?.apply {
                        Spacer(modifier = Modifier.width(dimen_24dp))

                        Icon(
                            modifier = Modifier
                                .size(dimen_24dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = true)
                                ) { secondIconOnPressClick() },
                            painter = painterResource(id = secondIconResource),
                            tint = secondIconColor ?: AppTheme.colors.colorPrimary,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    )
}