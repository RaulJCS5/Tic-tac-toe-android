package project.android.rauljcs5.ui.screen.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import project.android.rauljcs5.GameChallenge
import project.android.rauljcs5.Player
import project.android.rauljcs5.ui.screen.lobby.Challenge
import project.android.rauljcs5.ui.theme.TictactoeTheme
import project.android.rauljcs5.utils.viewModelInit

class GameActivity : ComponentActivity() {

    companion object {
        const val GAME_CHALLENGE_EXTRA = "GAME_CHALLENGE_EXTRA"
        fun navigate(origin: Context, localPlayer: Player, challenge: Challenge) {
            with(origin) {
                startActivity(
                    Intent(this, GameActivity::class.java).also {
                        it.putExtra(GAME_CHALLENGE_EXTRA, GameChallenge(localPlayer, challenge))
                    }
                )
            }
        }
    }

    private val viewModel: GameViewModel by viewModels {
        viewModelInit {
            GameViewModel()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            TictactoeTheme {
                viewModel.addGameChallenge(gameChallengeExtra)
                GameView(gameState = GameState(gameChallenge = viewModel.gameChallenge!!))
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        Log.v("TAG","Back button clicked game")
        finish()
    }

    @Suppress("deprecation")
    private val gameChallengeExtra: GameChallenge?
        get() =
            intent.getParcelableExtra(GAME_CHALLENGE_EXTRA, GameChallenge::class.java)

}