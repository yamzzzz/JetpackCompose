package com.yami.app.listgriddemo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.yami.app.listgriddemo.model.listItems
import com.yami.app.listgriddemo.utils.ListItem
import com.yami.app.listgriddemo.utils.SmallListItem
import com.yami.app.listgriddemo.widgets.MyAppBar
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HorizontalListScreen(drawerState: DrawerState,
                         scope: CoroutineScope,
                         title: String) {
    Scaffold(topBar = {
        MyAppBar(
            drawerState = drawerState,
            scope = scope,
            title = title
        )
    }) { padding ->
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(listItems) {
                SmallListItem(title = it.title, description = it.description, imageUrl = it.image)
            }
        }
    }
}