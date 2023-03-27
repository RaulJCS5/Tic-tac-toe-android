package project.android.rauljcs5.ui.screen.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import project.android.rauljcs5.*
import project.android.rauljcs5.ui.screen.game.firebase.MatchService
import project.android.rauljcs5.ui.screen.game.model.GameBoard
import project.android.rauljcs5.ui.screen.game.model.Position

enum class MatchState { IDLE, STARTING, STARTED, FINISHED }

class GameViewModel(private val matchService: MatchService) : ViewModel() {

    private val _onGoingGame = MutableStateFlow(Game())
    val onGoingGame = _onGoingGame.asStateFlow()

    private var _state by mutableStateOf(MatchState.IDLE)
    val state: MatchState
        get() = _state

    fun startMatch(localPlayer: Player, opponentPlayer: Player, gameChallengeExtra: GameChallenge): Job? =
        if (state == MatchState.IDLE) {
            _state = MatchState.STARTING
            viewModelScope.launch {
                val newGame = Game(
                    localPlayerMarker = getLocalPlayerMarker(localPlayer, gameChallengeExtra),
                    board = GameBoard()
                )
                _onGoingGame.value=newGame
                matchService.start(localPlayer, opponentPlayer,_onGoingGame.value)
                _state = MatchState.STARTED
            }
        }
        else null

    fun makeMove(at: Position): Job? =
        if (state == MatchState.STARTED) {
            viewModelScope.launch {
                matchService.makeMove(at)
            }
        }
        else null
}