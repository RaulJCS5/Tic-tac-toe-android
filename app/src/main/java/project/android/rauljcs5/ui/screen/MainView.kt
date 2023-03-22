package project.android.rauljcs5.ui.screen

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
fun MainView() {
    val isSignIn = remember {
        mutableStateOf(false)
    }
    val isSignUp = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        if (isSignIn.value) {
            SignInView() { isSignIn.value = false }
        } else if (isSignUp.value) {
            SignUpView() { isSignUp.value = false }
        } else {
            Box(modifier = Modifier.wrapContentSize(Alignment.Center)) {
                Box(Modifier.align(Alignment.Center)) {
                    Column {
                        Text(text = "Main view")
                        Button(onClick = { isSignIn.value = true }) {
                            Text(text = "Sign In")
                        }
                        Button(onClick = { isSignUp.value = true }) {
                            Text(text = "Sign Up")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    TictactoeTheme {
        MainView()
    }
}