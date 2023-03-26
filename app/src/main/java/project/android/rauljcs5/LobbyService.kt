package project.android.rauljcs5

import com.google.firebase.firestore.DocumentReference
import kotlinx.coroutines.flow.Flow
import project.android.rauljcs5.ui.screen.lobby.Challenge

sealed class LobbyEvent

interface LobbyService {
    suspend fun addPlayerToLobby(localPlayer: Player): DocumentReference
    suspend fun removePlayerFromLobby()
    suspend fun acceptChallenge(to: Player): Challenge
}
