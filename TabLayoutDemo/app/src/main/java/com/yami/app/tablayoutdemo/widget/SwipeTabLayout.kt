package com.yami.app.tablayoutdemo.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.yami.app.tablayoutdemo.util.TabScreens

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SwipeTabLayout() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val tabItems = listOf(TabScreens.HomeTab, TabScreens.NotificationTab, TabScreens.ProfileTab)
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedIndex) {
        pagerState.animateScrollToPage(selectedIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedIndex = pagerState.currentPage
        }
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = selectedIndex) {
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
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = tabItems[index].name)
            }
        }
    }
}