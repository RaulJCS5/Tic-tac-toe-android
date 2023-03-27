package project.android.rauljcs5.ui.screen.game

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import project.android.rauljcs5.DependenciesContainer
import project.android.rauljcs5.GameChallenge
import project.android.rauljcs5.Player
import project.android.rauljcs5.ui.screen.lobby.Challenge
import project.android.rauljcs5.ui.theme.TictactoeTheme
import project.android.rauljcs5.utils.viewModelInit
import java.util.*

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
            val app = (application as DependenciesContainer)
            GameViewModel(app.matchService)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentGame by viewModel.onGoingGame.collectAsState()
            TictactoeTheme {
                viewModel.addGameChallenge(gameChallengeExtra)
                GameView(
                    gameState = GameState(
                        gameChallenge = viewModel.gameChallenge!!,
                        gameBoard = currentGame
                    ),
                    onMoveRequested = { at -> viewModel.makeMove(at) },
                )
            }
        }
        if (viewModel.state == MatchState.IDLE){
            viewModel.startMatch(localPlayer, opponentPlayer)
        }
    }

    private val localPlayer: Player by lazy {
        Player(
            username = gameChallengeExtra.localUser,
            id = UUID.fromString(gameChallengeExtra.localId)
        )
    }

    private val opponentPlayer: Player by lazy {
        Player(
            username = gameChallengeExtra.opponentUser,
            id = UUID.fromString(gameChallengeExtra.opponentId)
        )
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        Log.v("TAG","Back button clicked game")
        finish()
    }

    @Suppress("deprecation")
    private val gameChallengeExtra: GameChallenge by lazy {
        val info =
            intent.getParcelableExtra(GAME_CHALLENGE_EXTRA, GameChallenge::class.java)
        checkNotNull(info)
    }

}