package br.com.athena.components.topbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import br.com.athena.R
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
    titleColor: Color = MaterialTheme.colors.onPrimary,
    mainIconResource: Int? = null,
    mainIconColor: Color? = null,
    mainIconOnPressClick: () -> Unit = {},
    firstIconResource: Int? = null,
    firstIconColor: Color? = null,
    firstIconOnPressClick: () -> Unit = {},
    secondIconResource: Int? = null,
    secondIconColor: Color? = null,
    secondIconOnPressClick: () -> Unit = {},
    backgroundColor: Color? = AppTheme.colors.colorSecondary,
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
    hasNavigationDrawer: Boolean? = false,
    navigationDrawerIcon: ImageVector = Icons.Default.Menu,
    onNavigationIconClick: () -> Unit = {}
) {
    TopAppBar(
        backgroundColor = backgroundColor ?: Color.White,
        elevation = elevation,
        modifier = modifier,
        navigationIcon = {
            if (hasNavigationDrawer == true) {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(
                        imageVector = navigationDrawerIcon,
                        contentDescription = "Toggle drawer",
                        tint = colorResource(id = R.color.colorPrimary),
                    )
                }
            }
        },
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