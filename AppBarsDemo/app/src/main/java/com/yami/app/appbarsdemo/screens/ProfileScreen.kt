package com.yami.app.appbarsdemo.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(drawerState: DrawerState, scope: CoroutineScope, name: String) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(title = {
                Text(text = name)
            }, navigationIcon = {
                IconButton(onClick = {
                    scope.launch { drawerState.open() }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Profile Screen")
                }
            }, actions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = "Search"
                    )
                }

                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Settings, contentDescription = "Settings"
                    )
                }
            },
                scrollBehavior = scrollBehavior

            )
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            LazyColumn(content = {
                items(50) { index: Int ->
                    Text(
                        text = "Item $index", modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                }
            })
        }
    }
}