package com.yami.app.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yami.app.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
    var nameValue by remember {
        mutableStateOf("")
    }
    var emailValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.kakashi),
            contentDescription = "Image",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp)
                .size(150.dp)
        )
        Row(modifier = Modifier.padding(vertical = 10.dp)) {
            Text(
                text = "Name: ",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(0.5f)
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                value = nameValue,
                onValueChange = {
                    nameValue = it
                })
        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
//            label = "Email Address",
//            placeholder = "Email",
//            keyboardActions = KeyboardOptions(keyboardType = KeyboardType.Email),
            value = emailValue,
            onValueChange = {
                emailValue = it
            }
        )

        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Hobbies: ", fontWeight = FontWeight.Bold)
        checkBoxes()
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text = "Sex: ", fontWeight = FontWeight.Bold)
        radioButtons()
        Spacer(modifier = Modifier.padding(20.dp))
        buttons()

    }
}


@Composable
fun checkBoxes() {
    val checkBoxList = remember {
        mutableStateListOf(
            CheckBoxItem(false, "Reading"),
            CheckBoxItem(false, "Movies"),
            CheckBoxItem(false, "Cooking"),
            CheckBoxItem(false, "Drawing"),
            CheckBoxItem(false, "Hiking")
        )
    }

    checkBoxList.forEachIndexed { index, item ->
        Row(verticalAlignment = Alignment.CenterVertically,
             modifier = Modifier
                 .clickable {
                     checkBoxList[index] = checkBoxList[index].copy(isChecked = !item.isChecked)
                 }
                 .padding(end = 10.dp)) {
            Checkbox(checked = item.isChecked, onCheckedChange = { value ->
                checkBoxList[index] = checkBoxList[index].copy(isChecked = value)

            })
            Text(text = item.text)
        }
    }

}

@Composable
fun radioButtons() {
    val radioList = remember {
        mutableStateListOf(
            CheckBoxItem(false, "Male"),
            CheckBoxItem(false, "Female")
        )
    }

    radioList.forEachIndexed { index, item ->
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    radioList.replaceAll {
                        it.copy(isChecked = it.text == item.text)
                    }
                }
                .padding(end = 10.dp)
        ) {
            RadioButton(selected = item.isChecked, onClick = {
                radioList.replaceAll {
                    it.copy(isChecked = it.text == item.text)
                }
            })
            Text(text = item.text)
        }
    }

}

@Composable
fun buttons(){
    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

    }
  /* Button(onClick = { *//*TODO*//* }) {
       Text(text = "Register")
   }*/
    /*ElevatedButton(onClick = { *//*TODO*//* }) {
        Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "Favorite", modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = "Add to Favorite")
    }*/
    /*FilledTonalButton(onClick = { *//*TODO*//* }) {
        Text(text = "Open in Browser")
    }*/
    /*OutlinedButton(onClick = { *//*TODO*//* }) {
        Text(text = "Cancel")
    }*/
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Learn more")
    }
}

data class CheckBoxItem(var isChecked: Boolean, var text: String)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        RegisterScreen()
    }
}