package project.android.rauljcs5.ui.screen.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import project.android.rauljcs5.*

enum class MatchState { IDLE, STARTING, STARTED, FINISHED }

class GameViewModel(private val matchService: MatchService) : ViewModel() {
    private var _gameChallenge by mutableStateOf<GameChallenge?>(null)
    var gameChallenge: GameChallenge?=null
        get() = _gameChallenge

    private var _state by mutableStateOf(MatchState.IDLE)
    val state: MatchState
        get() = _state

    fun addGameChallenge(gameChallengeExtra: GameChallenge?) {
        viewModelScope.launch {
            _gameChallenge=gameChallengeExtra
        }
    }

    fun startMatch(localPlayer: Player, opponentPlayer: Player): Job? =
        if (state == MatchState.IDLE) {
            _state = MatchState.STARTING
            viewModelScope.launch {
                matchService.start(localPlayer, opponentPlayer)
            }
        }
        else null
}