package project.android.rauljcs5.ui.screen.lobby

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.android.rauljcs5.LocalPlayerDto

class LobbyViewModel(): ViewModel() {
    private var _player by mutableStateOf<String?>(null)
    var player: String?=null
        get() = _player

    fun setPlayer(playerExtra: LocalPlayerDto?) {
        viewModelScope.launch {
            if (playerExtra!=null)
                _player=playerExtra.username
        }
    }
}