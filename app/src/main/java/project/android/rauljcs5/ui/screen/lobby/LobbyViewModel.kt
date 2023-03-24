package project.android.rauljcs5.ui.screen.lobby

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import project.android.rauljcs5.LocalPlayerDto
import project.android.rauljcs5.PlayerInfo

class LobbyViewModel(): ViewModel() {
    private var _player by mutableStateOf<PlayerInfo?>(null)
    var player: PlayerInfo?=null
        get() = _player
    private var lobbyMonitor: Job? = null


    private val _players = MutableStateFlow<List<PlayerInfo>>(emptyList())
    val players = _players.asStateFlow()

    private val _pendingMatch = MutableStateFlow<PendingChallenge?>(null)
    val pendingMatch = _pendingMatch.asStateFlow()

    fun setPlayer(playerExtra: LocalPlayerDto?) {
        viewModelScope.launch {
            if (playerExtra!=null)
                _player= PlayerInfo(playerExtra)
        }
    }

    fun matchPlayer(player: PlayerInfo) {
        viewModelScope.launch {
            _pendingMatch.value = SentChallenge(
                localPlayer = _player!!,
                challenge = Challenge(challenger = _player!!, challenged = player)
            )
        }
    }

    suspend fun joinLobby(): Job? =
        if (lobbyMonitor==null) {
            val eventObserver = viewModelScope.launch {
                val playerList = mutableListOf<PlayerInfo>()
                playerList.add(PlayerInfo("test1"))
                delay(3000)
                playerList.add(PlayerInfo("test2"))
                playerList.add(PlayerInfo("test3"))
                _players.value = playerList
            }
            lobbyMonitor=eventObserver
            eventObserver
        }
        else {
            null
        }

    fun leaveLobby(): Job? =
    if (lobbyMonitor != null) {
        viewModelScope.launch {
            lobbyMonitor?.cancel()
            lobbyMonitor = null
            _pendingMatch.value = null
        }
    } else null
}

/**
 * Data type that characterizes challenges.
 * @property challenger     The challenger information
 * @property challenged     The information of the challenged player
 */
data class Challenge(val challenger: PlayerInfo, val challenged: PlayerInfo)


/**
 * The player information of the first player to move for this challenge.
 */
val Challenge.firstToMove: PlayerInfo
    get() = challenger

sealed class PendingChallenge(val localPlayer: PlayerInfo, val challenge: Challenge)

class IncomingChallenge(localPlayer: PlayerInfo, challenge: Challenge)
    : PendingChallenge(localPlayer, challenge)

class SentChallenge(localPlayer: PlayerInfo, challenge: Challenge)
    : PendingChallenge(localPlayer, challenge)