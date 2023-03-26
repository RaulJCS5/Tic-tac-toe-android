package project.android.rauljcs5.ui.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import project.android.rauljcs5.ui.theme.TictactoeTheme

@Composable
fun MainView(
    onSignInRequested: (() -> Unit)? = null,
    onSignUpRequested: (() -> Unit)? = null,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(modifier = Modifier.wrapContentSize(Alignment.Center)) {
            Box(Modifier.align(Alignment.Center)) {
                Column {
                    Text(text = "Main view")
                    if (onSignInRequested != null) {
                        Button(onClick = onSignInRequested) {
                            Text(text = "Sign In")
                        }
                    }
                    if (onSignUpRequested != null) {
                        Button(onClick = onSignUpRequested) {
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