package project.android.rauljcs5.ui.screen.lobby

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import project.android.rauljcs5.LocalPlayerDto
import project.android.rauljcs5.ui.theme.TictactoeTheme
import project.android.rauljcs5.utils.viewModelInit

class LobbyActivity: ComponentActivity(){

    companion object {
        private const val PLAYER_EXTRA = "PLAYER_EXTRA"
        fun navigate(context: Activity, player: LocalPlayerDto? = null) {
            with(context) {
                val intent = Intent(this, LobbyActivity::class.java)
                if (player != null)
                    intent.putExtra(PLAYER_EXTRA, player)
                startActivity(intent)
            }
        }
    }

    private val viewModel: LobbyViewModel by viewModels {
        viewModelInit {
            LobbyViewModel()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            TictactoeTheme {
                viewModel.setPlayer(playerExtra)
                LobbyView(
                    player = viewModel.player!!
                )
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        Log.v("TAG","Back button clicked sign in")
        finish()
    }
    @Suppress("deprecation")
    private val playerExtra: LocalPlayerDto?
        get() =
            intent.getParcelableExtra(LobbyActivity.PLAYER_EXTRA, LocalPlayerDto::class.java)
}