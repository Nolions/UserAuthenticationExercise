package screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class RegisterScreen {
    @Composable
    fun RegisterScreen() {
        val scaffoldStateRegister = rememberScaffoldState()
        var textFieldStateFName by remember {
            mutableStateOf("")
        }
        var textFieldStateLName by remember {
            mutableStateOf("")
        }
        var textFieldStatePhone by remember {
            mutableStateOf("")
        }
        var textFieldStateREmail by remember {
            mutableStateOf("")
        }
        var textFieldStatePassword by remember {
            mutableStateOf("")
        }
        val scope = rememberCoroutineScope()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldStateRegister
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)
            ) {
                TextField(
                    value = textFieldStateFName,
                    label = {
                        Text("Enter your First Name")
                    },
                    onValueChange = {
                        textFieldStateFName = it
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = textFieldStateLName,
                    label = {
                        Text("Enter your Last Name")
                    },
                    onValueChange = {
                        textFieldStateLName = it
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = textFieldStateREmail,
                    label = {
                        Text("Enter your Email")
                    },
                    onValueChange = {
                        textFieldStateREmail = it
                    },

                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextField(
                    value = textFieldStatePhone,
                    label = {
                        Text("Enter your Phone Number")
                    },
                    onValueChange = {
                        textFieldStatePhone = it
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
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
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true, modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    scope.launch {
                        scaffoldStateRegister.snackbarHostState.showSnackbar("Button Clicked $textFieldStatePassword")
                    }
                }){
                    Text("Register")
                }
            }
        }
    }
}