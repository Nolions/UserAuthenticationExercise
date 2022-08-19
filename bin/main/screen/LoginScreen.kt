package screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class LoginScreen {
    @Composable
    fun LoginScreen(onBack: () -> Unit) {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        var textFieldStateEmail by remember {
            mutableStateOf("")
        }
        var textFieldStatePassword by remember {
            mutableStateOf("")
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            content = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)
                ) {
                    TextField(
                        value = textFieldStateEmail,
                        label = {
                            Text("Enter your Email")
                        },
                        onValueChange = {
                            textFieldStateEmail = it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = textFieldStatePassword,
                        label = {
                            Text("Enter your Password")
                        },
                        onValueChange = {
                            textFieldStatePassword = it
                        },
                        visualTransformation = PasswordVisualTransformation(), // Enable password input type by showing dots for password security
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Button Clicked $textFieldStateEmail")
                        }
                    }) {
                        Text("Login")
                    }

                    Button(onClick = onBack) {
                        Text(text = "Back")
                    }
                }
            }
        )
    }
}