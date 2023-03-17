package project.android.rauljcs5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import palbp.laboratory.demos.tictactoe.utils.viewModelInit
import project.android.rauljcs5.view.SignedInView

class SignedInActivity : ComponentActivity() {

    private val viewModel by viewModels<SignedInViewModel> {
        viewModelInit {
            val app = (application as DependenciesContainer)
            SignedInViewModel(app.userRepo)
        }
    }

    companion object {
        fun navigate(context: Context) {
            with(context) {
                // Cria um Intent para iniciar a SignedInActivity
                val intent = Intent(this, SignedInActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            SignedInView()
        }
    }

}
