package project.android.rauljcs5.ui.screen.game.firebase

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import project.android.rauljcs5.Player
import project.android.rauljcs5.ui.screen.game.Game
import project.android.rauljcs5.ui.screen.game.makeMove
import project.android.rauljcs5.ui.screen.game.model.GameBoard
import project.android.rauljcs5.ui.screen.game.model.Marker
import project.android.rauljcs5.ui.screen.game.model.Position

const val PLAYING = "playing"

class MatchFirebase(private val realFirestoreDb: FirebaseFirestore) : MatchService {

    private var onGoingGame: Pair<Game, String>? = null

    override suspend fun start(local: Player, opponent: Player, game: Game) {
        publishGame(game.board, local, opponent)
        onGoingGame = Pair(game, local.id.toString())
    }

    private suspend fun publishGame(board:GameBoard, local: Player, opponent: Player) {
        realFirestoreDb.collection(PLAYING)
            .document(local.id.toString())
            .set(board.toDocumentContent(local,opponent))
            .await()
    }

    override suspend fun makeMove(at: Position) {
        onGoingGame = checkNotNull(onGoingGame).also {
            val game = it.copy(first = it.first.makeMove(at))
            updateGame(game.first, game.second)
        }
    }

    private suspend fun updateGame(game: Game, gameId: String) {
        realFirestoreDb.collection(PLAYING)
            .document(gameId)
            .update(game.board.toDocumentContent())
            .await()
    }

    override suspend fun end() {
        onGoingGame = checkNotNull(onGoingGame).let {
            realFirestoreDb.collection(PLAYING)
                .document(it.second)
                .delete()
                .await()
            null
        }
    }

}

const val TURN_FIELD = "turn"
const val BOARD_FIELD = "board"
const val LOCAL = "local"
const val OPPONENT = "opponent"

fun GameBoard.toDocumentContent(local: Player,opponent: Player) = mapOf(
    LOCAL to local,
    OPPONENT to opponent,
    TURN_FIELD to turn.name,
    BOARD_FIELD to toMovesList().joinToString(separator = "") {
        when (it) {
            Marker.CROSS -> "X"
            Marker.CIRCLE -> "O"
            null -> "-"
        }
    }
)

fun GameBoard.toDocumentContent() = mapOf(
    TURN_FIELD to turn.name,
    BOARD_FIELD to toMovesList().joinToString(separator = "") {
        when (it) {
            Marker.CROSS -> "X"
            Marker.CIRCLE -> "O"
            null -> "-"
        }
    }
)
