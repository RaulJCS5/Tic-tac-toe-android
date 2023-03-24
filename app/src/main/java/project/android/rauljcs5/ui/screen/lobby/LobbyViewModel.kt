package project.android.rauljcs5.ui.screen.lobby

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import project.android.rauljcs5.LocalPlayerDto
import project.android.rauljcs5.PlayerInfo

class LobbyViewModel(): ViewModel() {
    private var _player by mutableStateOf<PlayerInfo?>(null)
    var player: PlayerInfo?=null
        get() = _player

    private val _players = MutableStateFlow<List<PlayerInfo>>(emptyList())
    val players = _players.asStateFlow()

    fun setPlayer(playerExtra: LocalPlayerDto?) {
        viewModelScope.launch {
            if (playerExtra!=null)
                _player= PlayerInfo(playerExtra)
        }
    }

    fun matchPlayer(player: PlayerInfo) {
        //TODO("Not yet implemented")
    }

    fun addPlayers() {
        val playerList = mutableListOf<PlayerInfo>()
        playerList.add(PlayerInfo("test1"))
        playerList.add(PlayerInfo("test2"))
        playerList.add(PlayerInfo("test3"))
        _players.value= playerList
    }
}