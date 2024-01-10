package br.com.athena.components.navigationdrawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import br.com.athena.components.texts.AthenaText_16Bold
import br.com.athena.components.texts.AthenaText_16Normal
import br.com.athena.theme.Dimensions.dimen_16dp
import br.com.athena.theme.Dimensions.dimen_64dp

@Composable
fun AthenaNavigationDrawer(
    items: List<AthenaNavigationDrawerItem> = defaultScreens,
    onItemClick: (AthenaNavigationDrawerItem) -> Unit
) {
    AthenaDrawerHeader()
    AthenaDrawerBody(
        items = items,
        onItemClick = onItemClick
    )
}

@Composable
private fun AthenaDrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = dimen_64dp)
    ) {
        AthenaText_16Bold(text = "Header")
    }
}

@Composable
private fun AthenaDrawerBody(
    items: List<AthenaNavigationDrawerItem>,
    modifier: Modifier = Modifier,
    onItemClick: (AthenaNavigationDrawerItem) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimen_16dp)
                    .clickable {
                        onItemClick(item)
                    }
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription,
                    tint = colorResource(id = item.iconColor)
                )
                Spacer(modifier = Modifier.width(dimen_16dp))
                AthenaText_16Normal(
                    modifier = Modifier.weight(1f),
                    text = item.title
                )
            }
        }
    }
}

private val defaultScreens = listOf(
    AthenaNavigationDrawerItem.Home,
    AthenaNavigationDrawerItem.Settings,
    AthenaNavigationDrawerItem.Help,
)