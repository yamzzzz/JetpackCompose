package com.yami.app.appdrawerdemo.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.yami.app.appdrawerdemo.widgets.MyAppBar
import kotlinx.coroutines.CoroutineScope

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ScreenContent(
    drawerState: DrawerState,
    scope: CoroutineScope,
    title: String
) {
    Scaffold(topBar = {
        MyAppBar(
            drawerState = drawerState,
            scope = scope,
            title = title
        )
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontSize = TextUnit(30F, TextUnitType.Sp))
        }
    }
}