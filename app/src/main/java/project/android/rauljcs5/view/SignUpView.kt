package project.android.rauljcs5.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import project.android.rauljcs5.ui.theme.TictactoeTheme

@Composable
fun SignUpView(goBackSignUp:()->Unit={}) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val name = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val phoneNumber = remember { mutableStateOf("") }
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        Box(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)) {
            Box(Modifier.align(Alignment.Center)) {
                Column {
                    Text(text = "Sign up")
                    TextField(
                        label = { Text(text = "Name") },
                        value = name.value,
                        onValueChange = { name.value = it })
                    TextField(
                        label = { Text(text = "Email") },
                        value = email.value,
                        onValueChange = { email.value = it })
                    TextField(
                        label = { Text(text = "Phone number") },
                        value = phoneNumber.value,
                        onValueChange = { phoneNumber.value = it })
                    TextField(
                        label = { Text(text = "Username") },
                        value = username.value,
                        onValueChange = { username.value = it })
                    TextField(
                        label = { Text(text = "Password") },
                        value = password.value,
                        onValueChange = { password.value = it })
                    Button(onClick = goBackSignUp) {
                        Text(text = "Go back")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    TictactoeTheme {
        SignUpView()
    }
}