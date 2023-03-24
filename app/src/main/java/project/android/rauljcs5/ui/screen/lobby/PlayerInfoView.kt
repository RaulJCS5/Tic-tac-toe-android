package project.android.rauljcs5.ui.screen.lobby

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import project.android.rauljcs5.PlayerInfo

@Composable
fun PlayerInfoView(
    playerInfo: PlayerInfo,
    onPlayerSelected: (PlayerInfo) -> Unit
){
    Card(
        modifier = Modifier
            .clickable { onPlayerSelected(playerInfo) }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = playerInfo.username,
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}