package project.android.rauljcs5.ui.screen.lobby.firebase

import com.google.firebase.firestore.DocumentReference
import project.android.rauljcs5.Player
import project.android.rauljcs5.ui.screen.lobby.Challenge

sealed class LobbyEvent

interface LobbyService {
    suspend fun addPlayerToLobby(localPlayer: Player): DocumentReference
    suspend fun removePlayerFromLobby()
    suspend fun acceptChallenge(to: Player): Challenge
}
