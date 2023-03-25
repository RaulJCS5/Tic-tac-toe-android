package project.android.rauljcs5.ui.screen.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.android.rauljcs5.GameChallenge

class GameViewModel : ViewModel() {
    private var _gameChallenge by mutableStateOf<GameChallenge?>(null)
    var gameChallenge: GameChallenge?=null
        get() = _gameChallenge

    fun addGameChallenge(gameChallengeExtra: GameChallenge?) {
        viewModelScope.launch {
            _gameChallenge=gameChallengeExtra
        }
    }
}