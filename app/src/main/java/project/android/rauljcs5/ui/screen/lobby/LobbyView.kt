package project.android.rauljcs5.ui.screen.lobby

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import project.android.rauljcs5.PlayerInfo

data class LobbyState(
    val players: List<PlayerInfo> = emptyList()
)

@Composable
fun LobbyView(
    state: LobbyState = LobbyState(),
    player: PlayerInfo,
    onPlayerSelected: (PlayerInfo) -> Unit = { },
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(modifier = Modifier.wrapContentSize(Alignment.Center)) {
            Box(Modifier.align(Alignment.Center)) {
                Column {
                    Text(text = "You are in lobby ${player.username}")
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        items(state.players){
                            PlayerInfoView(playerInfo = it, onPlayerSelected = onPlayerSelected)
                        }
                    }
                }
            }
        }
    }
}