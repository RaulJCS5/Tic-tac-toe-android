package project.android.rauljcs5

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await

const val LOBBY = "lobby"
const val USERNAME = "username"

class LobbyFirebase(private val db: FirebaseFirestore) : LobbyService {
    private var state: LobbyState = Idle
    private sealed class LobbyState
    private object Idle : LobbyState()
    private class InUse(
        val document: DocumentReference
    ): LobbyState()

    override suspend fun addPlayerToLobby(localPlayer: Player): DocumentReference {
        val docRef = db.collection(LOBBY).document(localPlayer.id.toString())
        docRef
            .set(localPlayer.toDocumentContent())
            .await()
        state = InUse(docRef)
        return docRef
    }

    override suspend fun removePlayerFromLobby() {
        when(val currentState = state){
            is InUse -> currentState.document.delete().await()
            is Idle -> throw IllegalStateException()
        }
        state = Idle
    }

}

fun Player.toDocumentContent() = mapOf(
    USERNAME to username,
)