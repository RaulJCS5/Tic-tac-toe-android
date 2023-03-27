package project.android.rauljcs5.ui.screen.game

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import project.android.rauljcs5.GameChallenge
import project.android.rauljcs5.ui.screen.game.model.GameBoard
import project.android.rauljcs5.ui.screen.game.model.Position

data class GameState(
    val gameChallenge:GameChallenge,
    val gameBoard: GameBoard
)
@Composable
fun GameView(
    gameState:GameState,
    onMoveRequested: (Position) -> Unit = { },
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "${gameState.gameChallenge.localUser} vs ${gameState.gameChallenge.opponentUser}")
        BoardView(
            board = gameState.gameBoard,
            onTileSelected = onMoveRequested,
            modifier = Modifier
                .padding(32.dp)
                .weight(1.0f, true)
                .fillMaxSize()
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}