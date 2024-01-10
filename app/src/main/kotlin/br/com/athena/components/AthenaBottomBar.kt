package br.com.athena.components

import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.athena.theme.AppTheme

@Composable
fun AthenaBottomBar(
    items: List<BottomNavigationItem>
) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    BottomNavigation(
        backgroundColor = AppTheme.colors.colorSecondary
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = selectedItemIndex == index,
                onClick = { selectedItemIndex = index },
                label = {
                    Text(text = item.title)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) item.selectedIcon
                                else item.unselectedIcon,
                            contentDescription = null,
                            tint = AppTheme.colors.colorPrimary
                        )
                    }
                }
            )
        }
    }
}

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)