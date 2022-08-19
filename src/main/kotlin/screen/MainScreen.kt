package screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainScreen(private var screen: MutableState<Screen>) {

    @Composable
    fun mainScreen() {

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                screen.value = Screen.LoginScreen
            }) {
                Text("Login")
            }

            Button(onClick = {
                screen.value = Screen.RegisterScreen
            }) {
                Text("Register")
            }
        }
    }
}