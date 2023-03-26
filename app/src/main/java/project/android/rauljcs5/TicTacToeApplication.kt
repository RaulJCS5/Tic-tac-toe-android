package project.android.rauljcs5

import android.app.Application
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import project.android.rauljcs5.ui.screen.game.firebase.MatchFirebase
import project.android.rauljcs5.ui.screen.game.firebase.MatchService
import project.android.rauljcs5.ui.screen.lobby.firebase.LobbyFirebase
import project.android.rauljcs5.ui.screen.lobby.firebase.LobbyService


interface DependenciesContainer {
    val lobbyService : LobbyService
    val matchService : MatchService
}

class TicTacToeApplication : DependenciesContainer, Application() {
    private val realFirestoreDb: FirebaseFirestore by lazy {
        Firebase.firestore
    }

    override val lobbyService: LobbyService
        get() = LobbyFirebase(realFirestoreDb)

    override val matchService: MatchService
        get() = MatchFirebase(realFirestoreDb)

}