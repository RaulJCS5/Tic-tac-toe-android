package project.android.rauljcs5.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import project.android.rauljcs5.ui.theme.TictactoeTheme

@Composable
fun SignedInView(logout:()->Unit={}) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(modifier = Modifier.wrapContentSize(Alignment.Center)) {
            Box(Modifier.align(Alignment.Center)) {
                Column {
                    Text(text = "Welcome")
                    Button(onClick = logout) {
                        Text(text = "Logout")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignedInPreview() {
    TictactoeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            SignedInView()
        }
    }
}