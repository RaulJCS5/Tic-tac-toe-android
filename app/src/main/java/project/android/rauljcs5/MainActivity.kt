package project.android.rauljcs5

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import project.android.rauljcs5.ui.theme.TictactoeTheme
import project.android.rauljcs5.view.MainView

class MainActivity : ComponentActivity() {

    private val repo by lazy {
        (application as DependenciesContainer).userRepo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TictactoeTheme {
                MainView(signedIn = ::signedIn)
            }
        }
    }

    private fun signedIn() {
        SignedInActivity.navigate(this)
        finish()
    }
}