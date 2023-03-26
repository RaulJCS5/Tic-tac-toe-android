package project.android.rauljcs5.ui.screen.lobby.firebase

import android.util.Log
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import project.android.rauljcs5.Player
import project.android.rauljcs5.ui.screen.lobby.Challenge

const val LOBBY = "lobby"
const val CHALLENGER_FIELD = "challenger"
const val USERNAME = "username"

class LobbyFirebase(private val db: FirebaseFirestore) : LobbyService {
    private var state: LobbyState = Idle
    private sealed class LobbyState
    private object Idle : LobbyState()
    private class InUse(
        val localPlayer: Player,
        val document: DocumentReference
    ): LobbyState()

    override suspend fun addPlayerToLobby(localPlayer: Player): DocumentReference {
        val docRef = db.collection(LOBBY).document(localPlayer.id.toString())
        docRef
            .set(localPlayer.toDocumentContent())
            .await()
        state = InUse(localPlayer,docRef)
        return docRef
    }

    override suspend fun removePlayerFromLobby() {
        when(val currentState = state){
            is InUse -> currentState.document.delete().await()
            is Idle -> throw IllegalStateException()
        }
        state = Idle
    }

    override suspend fun acceptChallenge(to: Player): Challenge {
        //TODO("Accept challenge")
        val localPlayer = when (val currentState = state) {
            is Idle -> throw java.lang.IllegalStateException()
            is InUse -> currentState.localPlayer
        }
        val documentRef = db.collection(LOBBY).document(to.id.toString())
        val documentSnapshot = documentRef.get().await()

        if (documentSnapshot.exists()) {
            documentRef.update(CHALLENGER_FIELD, localPlayer.toDocumentContent()).await()
        } else {
            Log.v("Tag","Did not update")
        }
        return Challenge(challenger = localPlayer, challenged = to)
    }

}

fun Player.toDocumentContent() = mapOf(
    USERNAME to username,
)