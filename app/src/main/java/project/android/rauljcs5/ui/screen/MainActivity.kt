package project.android.rauljcs5.ui.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import project.android.rauljcs5.DependenciesContainer
import project.android.rauljcs5.ui.theme.TictactoeTheme

class MainActivity : ComponentActivity() {

    private val repo by lazy {
        (application as DependenciesContainer).userRepo
    }

    companion object {
        fun navigate(context: Context) {
            with(context) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TictactoeTheme {
                MainView()
            }
        }
    }
}