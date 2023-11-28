package com.yami.app.listgriddemo.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yami.app.listgriddemo.model.listItems
import com.yami.app.listgriddemo.utils.ListItem
import com.yami.app.listgriddemo.utils.SmallListItem
import com.yami.app.listgriddemo.widgets.MyAppBar
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridScreen(drawerState: DrawerState,
               scope: CoroutineScope,
               title: String) {
    Scaffold(topBar = {
        MyAppBar(
            drawerState = drawerState,
            scope = scope,
            title = title
        )
    }) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 100.dp),//GridCells.FixedSize(size = 100.dp),//GridCells.Fixed(count = 3),
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            items(listItems) { item ->
                SmallListItem(title = item.title, description = item.description, imageUrl = item.image)
            }
        }
    }
}