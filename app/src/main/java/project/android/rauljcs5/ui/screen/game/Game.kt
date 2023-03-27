package project.android.rauljcs5.ui.screen.game

import project.android.rauljcs5.GameChallenge
import project.android.rauljcs5.Player
import project.android.rauljcs5.ui.screen.game.model.GameBoard
import project.android.rauljcs5.ui.screen.game.model.Marker
import project.android.rauljcs5.ui.screen.game.model.Position

data class Game(
    val localPlayerMarker: Marker = Marker.firstToMove,
    val forfeitedBy: Marker? = null,
    val board: GameBoard = GameBoard()
)

fun Game.makeMove(at: Position): Game {
    check(localPlayerMarker == board.turn)
    return copy(board = board.makeMove(at))
}

fun getLocalPlayerMarker(localPlayer: Player, challenge: GameChallenge) =
    if (localPlayer.username == challenge.localUser) Marker.firstToMove
    else Marker.firstToMove.other
