package project.android.rauljcs5

import com.google.firebase.firestore.DocumentReference
import kotlinx.coroutines.flow.Flow

sealed class LobbyEvent

interface LobbyService {
    suspend fun addPlayerToLobby(localPlayer: Player): DocumentReference
    suspend fun removePlayerFromLobby()
}
