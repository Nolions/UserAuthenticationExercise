// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screen.LoginScreen
import screen.RegisterScreen

sealed class Screen {
    object LoginScreen : Screen()
    object RegisterScreen : Screen()
    object Main : Screen()
}

@Composable
@Preview
fun App() {
    var screen: Screen by remember { mutableStateOf(Screen.Main) }
    MaterialTheme {

        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement =  Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                screen = Screen.LoginScreen
            }) {
                Text("Login")
            }

            Button(onClick = {
                screen = Screen.RegisterScreen
            }) {
                Text("Register")
            }
        }
    }

    when (screen) {
        Screen.LoginScreen -> LoginScreen().LoginScreen()
        Screen.RegisterScreen -> RegisterScreen().RegisterScreen()
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
