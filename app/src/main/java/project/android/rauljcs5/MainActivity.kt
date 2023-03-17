package project.android.rauljcs5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import project.android.rauljcs5.ui.theme.TictactoeTheme
import project.android.rauljcs5.view.DefaultView

class MainActivity : ComponentActivity() {

    private val repo by lazy {
        (application as DependenciesContainer).userRepo
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TictactoeTheme {
                DefaultView(signedIn = ::signedIn, signedUp = ::signedUp)
            }
        }
    }

    private fun signedIn(){
        //SignedInActivity.navigate(this)
    }

    private fun signedUp(){
        //SignedInActivity.navigate(this)
    }
}