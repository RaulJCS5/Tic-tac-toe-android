package project.android.rauljcs5.ui.screen.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import project.android.rauljcs5.DependenciesContainer
import project.android.rauljcs5.ui.screen.signin.SignInActivity
import project.android.rauljcs5.ui.screen.signup.SignUpActivity
import project.android.rauljcs5.ui.theme.TictactoeTheme
import project.android.rauljcs5.utils.viewModelInit

class MainActivity : ComponentActivity() {

    private val repo by lazy {
        (application as DependenciesContainer).userRepo
    }

    private val viewModel: MainViewModel by viewModels {
        viewModelInit {
            MainViewModel()
        }
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
                MainView(
                    onSignInRequested = { SignInActivity.navigate(context = this) },
                    onSignUpRequested = { SignUpActivity.navigate(context = this) }
                )
            }
        }
    }
}