package project.android.rauljcs5

import android.content.Context
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

    companion object {
        fun navigate(context: Context) {
            with(context) {
                // Cria um Intent para iniciar a SignedInActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TictactoeTheme {
                MainView(signedIn = ::signedIn)
            }
        }
    }

    private fun signedIn(username:String) {
        SignedInActivity.navigate(this,username)
        finish()
    }
}