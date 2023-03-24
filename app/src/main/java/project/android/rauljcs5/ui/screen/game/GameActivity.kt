package project.android.rauljcs5.ui.screen.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import project.android.rauljcs5.GameChallengeInfo
import project.android.rauljcs5.LocalPlayerDto
import project.android.rauljcs5.PlayerInfo
import project.android.rauljcs5.ui.screen.lobby.Challenge
import project.android.rauljcs5.ui.screen.lobby.LobbyActivity
import project.android.rauljcs5.ui.theme.TictactoeTheme
import project.android.rauljcs5.utils.viewModelInit

class GameActivity : ComponentActivity() {

    companion object {
        const val GAME_INFO_EXTRA = "MATCH_INFO_EXTRA"
        fun navigate(origin: Context, localPlayer: PlayerInfo, challenge: Challenge) {
            with(origin) {
                startActivity(
                    Intent(this, GameActivity::class.java).also {
                        it.putExtra(GAME_INFO_EXTRA, GameChallengeInfo(localPlayer, challenge))
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
                viewModel.addGameInfo(gameInfoExtra)
                GameView(gameState = GameState(gameInfo = viewModel.gameInfo!!))
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        Log.v("TAG","Back button clicked game")
        finish()
    }

    @Suppress("deprecation")
    private val gameInfoExtra: GameChallengeInfo?
        get() =
            intent.getParcelableExtra(GAME_INFO_EXTRA, GameChallengeInfo::class.java)

}