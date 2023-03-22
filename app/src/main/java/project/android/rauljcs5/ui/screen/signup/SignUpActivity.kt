package project.android.rauljcs5.ui.screen.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import project.android.rauljcs5.toLocalDto
import project.android.rauljcs5.ui.screen.main.MainActivity
import project.android.rauljcs5.ui.theme.TictactoeTheme
import project.android.rauljcs5.utils.viewModelInit

class SignUpActivity : ComponentActivity() {

    private val viewModel: SignUpViewModel by viewModels {
        viewModelInit {
            SignUpViewModel()
        }
    }

    companion object {
        fun navigate(context: Context) {
            with(context) {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TictactoeTheme {
                SignUpView(goBackSignUp = {
                    MainActivity.navigate(origin = this)
                    finish()
                },
                    onUserSignUp = {
                        MainActivity.navigate(origin = this, user = it.toLocalDto())
                        finish()
                    }
                )
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        Log.v("TAG","Back button clicked sign up")
        MainActivity.navigate(origin = this)
        finish()
    }
}