package project.android.rauljcs5.ui.screen.game

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import project.android.rauljcs5.GameChallengeInfo

data class GameState(
    val gameInfo:GameChallengeInfo
)

@Composable
fun GameView(
    gameState:GameState
){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(modifier = Modifier.wrapContentSize(Alignment.Center)) {
            Box(Modifier.align(Alignment.Center)) {
                Column {
                    Text(text = "${gameState.gameInfo.localUser} vs ${gameState.gameInfo.opponentUser}")
                }
            }
        }
    }
}