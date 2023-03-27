package project.android.rauljcs5.ui.screen.game.firebase

import project.android.rauljcs5.Player
import project.android.rauljcs5.ui.screen.game.Game
import project.android.rauljcs5.ui.screen.game.model.GameBoard
import project.android.rauljcs5.ui.screen.game.model.Position

interface MatchService {
    suspend fun start(local: Player, opponent: Player, game: Game)

    suspend fun makeMove(at: Position)

    suspend fun end()
}
