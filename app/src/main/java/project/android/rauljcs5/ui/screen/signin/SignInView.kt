package project.android.rauljcs5.ui.screen.signin

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
import project.android.rauljcs5.User
import project.android.rauljcs5.ui.theme.TictactoeTheme

@Composable
fun SignInView(goBackSignIn:()->Unit={},
               onUserSignIn: (User) -> Unit = { }) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val username = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        ) {
            Box(Modifier.align(Alignment.Center)) {
                Column {
                    Text(text = "Sign in")
                    TextField(
                        label = { Text(text = "Username") },
                        value = username.value,
                        onValueChange = { username.value = it })
                    TextField(
                        label = { Text(text = "Password") },
                        value = password.value,
                        onValueChange = { password.value = it })
                    Button(onClick = {
                        if (username.value.isNotBlank() && password.value.isNotBlank())
                            onUserSignIn(User(username = username.value, password = password.value))
                    }) {
                        Text(text = "Sign in")
                    }
                    Button(onClick = goBackSignIn) {
                        Text(text = "Go back")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    TictactoeTheme {
        SignInView()
    }
}