package project.android.rauljcs5.ui.screen.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.android.rauljcs5.GameChallengeInfo
import project.android.rauljcs5.PlayerInfo

class GameViewModel : ViewModel() {
    private var _gameInfo by mutableStateOf<GameChallengeInfo?>(null)
    var gameInfo: GameChallengeInfo?=null
        get() = _gameInfo

    fun addGameInfo(gameInfoExtra: GameChallengeInfo?) {
        viewModelScope.launch {
            _gameInfo=gameInfoExtra
        }
    }
}