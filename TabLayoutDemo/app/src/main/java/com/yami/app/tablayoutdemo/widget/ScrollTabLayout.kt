package com.yami.app.tablayoutdemo.widget

import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.yami.app.tablayoutdemo.util.TabScreens

@Composable
fun ScrollTabLayout() {
    var selectedIndex by remember { mutableStateOf(1) }
    val tabItems = listOf(
        TabScreens.HomeTab,
        TabScreens.NotificationTab,
        TabScreens.ProfileTab,
        TabScreens.HomeTab,
        TabScreens.NotificationTab,
        TabScreens.ProfileTab,
        TabScreens.HomeTab,
        TabScreens.NotificationTab,
        TabScreens.ProfileTab
    )

    ScrollableTabRow(selectedTabIndex = selectedIndex) {
        tabItems.forEachIndexed { index, tabScreen ->
            Tab(
                selected = selectedIndex == index, onClick = { selectedIndex = index },
                text = { Text(text = tabScreen.name) },
                icon = {
                    Icon(
                        imageVector = if (selectedIndex == index) {
                            tabScreen.selectedIcon
                        } else {
                            tabScreen.unSelectedIcon
                        },
                        contentDescription = tabScreen.name
                    )

                }
            )
        }
    }
}
