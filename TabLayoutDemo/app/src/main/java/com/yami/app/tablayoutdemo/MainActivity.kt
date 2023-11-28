package com.yami.app.tablayoutdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yami.app.tablayoutdemo.ui.theme.TabLayoutDemoTheme
import com.yami.app.tablayoutdemo.util.TabScreens
import com.yami.app.tablayoutdemo.widget.ScrollTabLayout
import com.yami.app.tablayoutdemo.widget.SimpleTabLayout
import com.yami.app.tablayoutdemo.widget.SwipeTabLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabLayoutDemoTheme {
                SimpleTabLayout()
//                ScrollTabLayout()
//                SwipeTabLayout()
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TabLayoutDemoTheme {
        Greeting("Android")
    }
}