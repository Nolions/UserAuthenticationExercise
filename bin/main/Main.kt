// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import screen.LoginScreen
import screen.MainScreen
import screen.RegisterScreen
import screen.Screen

@Composable
@Preview
fun App() {
    val screen: MutableState<Screen> = remember { mutableStateOf(Screen.MainScreen) }
    val registerScreen = RegisterScreen()
    val loginScreen = LoginScreen()
    val mainScreen = MainScreen(screen)

    MaterialTheme {
    }

    when (screen.value) {
        Screen.MainScreen -> mainScreen.mainScreen()
        Screen.LoginScreen -> loginScreen.LoginScreen() { screen.value = Screen.MainScreen }
        Screen.RegisterScreen -> registerScreen.RegisterScreen() { screen.value = Screen.MainScreen }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
