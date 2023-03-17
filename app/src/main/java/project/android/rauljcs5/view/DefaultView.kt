package project.android.rauljcs5.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import project.android.rauljcs5.ui.theme.TictactoeTheme

@Composable
fun DefaultView(signedIn: () -> Unit = {}, signedUp: () -> Unit = {}) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(modifier = Modifier.wrapContentSize(Alignment.Center)) {
            Box(Modifier.align(Alignment.Center)) {
                Column {
                    Text(text = "Default view")
                    Button(onClick = signedIn) {
                        Text(text = "Sign In")
                    }
                    Button(onClick = signedUp ) {
                        Text(text = "Sign Up")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TictactoeTheme {
        DefaultView()
    }
}