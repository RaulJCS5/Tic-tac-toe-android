package project.android.rauljcs5.ui.screen.main

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import project.android.rauljcs5.DependenciesContainer
import project.android.rauljcs5.LocalUserDto
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
        private const val USER_EXTRA = "USER_EXTRA"
        fun navigate(origin: Activity, user: LocalUserDto? = null) {
            with(origin) {
                val intent = Intent(this, MainActivity::class.java)
                if (user != null)
                    intent.putExtra(USER_EXTRA, user)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TictactoeTheme {
                if (userExtra == null) {
                    MainView(
                        onSignInRequested = {
                            SignInActivity.navigate(context = this)
                            finish()
                        },
                        onSignUpRequested = {
                            SignUpActivity.navigate(context = this)
                            finish()
                        }
                    )
                } else {
                    SignedInView(logout = {}, username = "fake")
                }
            }
        }
    }
    @Suppress("deprecation")
    private val userExtra: LocalUserDto?
        get() =
            intent.getParcelableExtra(USER_EXTRA, LocalUserDto::class.java)
}