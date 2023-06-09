package project.android.rauljcs5.ui.screen.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import project.android.rauljcs5.LocalPlDto
import project.android.rauljcs5.Player
import project.android.rauljcs5.toLocalDto
import project.android.rauljcs5.ui.screen.lobby.LobbyActivity
import project.android.rauljcs5.ui.screen.signin.SignInActivity
import project.android.rauljcs5.ui.screen.signup.SignUpActivity
import project.android.rauljcs5.ui.theme.TictactoeTheme
import project.android.rauljcs5.utils.viewModelInit

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels {
        viewModelInit {
            MainViewModel()
        }
    }

    companion object {
        private const val USER_EXTRA = "USER_EXTRA"
        fun navigate(origin: Activity, user: LocalPlDto? = null) {
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
                viewModel.setLogin(userExtra)
                if (viewModel.username == null) {
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
                    UserHome(
                        logout = {
                            intent.removeExtra(USER_EXTRA)
                            viewModel.logout()
                        },
                        username = viewModel.username!!,
                        onLobbyRequested = {
                            LobbyActivity.navigate(context = this, player = Player(viewModel.username!!).toLocalDto())
                            //finish()
                        }
                    )
                }
            }
        }
    }
    @Suppress("deprecation")
    private val userExtra: LocalPlDto?
        get() =
            intent.getParcelableExtra(USER_EXTRA, LocalPlDto::class.java)
}